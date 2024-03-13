package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations

import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.quaternionRotationFromEulerAngles
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Animation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.AnimationHelper.interpolateBackAndForth
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType.*
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Robot
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.translate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.withOffset
import kotlin.math.cos
import kotlin.math.sin


class ArmAnimation(private var counter : Long = 0L) : Animation {

    enum class Phase {
        Forward,
        Side,
        BothLeft,
        BothRight
    }

    private val phase : Phase
        get() =
            when {
                counter < 2000L -> Phase.Forward
                counter < 4000L -> Phase.Side
                counter < 5000L -> Phase.BothLeft
                else -> Phase.BothRight
            }

    private val armAngleInDegrees : Double
        get() =
            when(phase) {
                Phase.Forward ->
                    interpolateBackAndForth(counter, 1000L, 45.0)
                Phase.Side ->
                    interpolateBackAndForth(counter, 1000L, 60.0)
                Phase.BothLeft ->
                    interpolateBackAndForth(counter, 1000L, 45.0)
                Phase.BothRight ->
                    interpolateBackAndForth(counter, 1000L, 45.0)
            }


    override fun update(counter : Long) {
        this.counter = counter % 6000L
    }

    private val liftedLimbs : Set<LimbType>
        get() =
            when(phase) {
                Phase.Forward, Phase.Side ->
                    if (counter % 2000L < 1000)
                        setOf(UpperLeftArm, LowerLeftArm, LeftHand)
                    else
                        setOf(UpperRightArm, LowerRightArm, RightHand)
                Phase.BothLeft, Phase.BothRight ->
                    setOf(UpperLeftArm, LowerLeftArm, LeftHand, UpperRightArm, LowerRightArm, RightHand)
            }

    override fun transform(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        if (!liftedLimbs.contains(limbType)) {
            return limb
        }

        return when(phase) {
            Phase.Forward ->
                transformForward(limbType, limb)
            Phase.Side ->
                transformSide(limbType, limb)
            Phase.BothLeft ->
                transformSide(limbType, transformForward(limbType, limb))
            Phase.BothRight ->
                transformSide(limbType, transformForward(limbType, limb))
        }
    }

    fun transformSide(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        // Rotating the arm the arm go up and to the sides, calculate by how much
        val upperArmRotationYOffset =
            (cos(Math.toRadians(armAngleInDegrees)) * Robot.upperArmHeight) - Robot.upperArmHeight
        val upperArmRotationXOffset = - (sin(Math.toRadians(armAngleInDegrees)) * Robot.upperArmHeight)

        val lowerArmRotationYOffset =
            (cos(Math.toRadians(armAngleInDegrees * 2.0)) * Robot.lowerArmHeight) - Robot.lowerArmHeight
        val lowerArmRotationXOffset = - (sin(Math.toRadians(armAngleInDegrees * 2.0)) * Robot.lowerArmHeight)

        fun upperArm(left : Boolean) : Array<Coordinate> {
            return limb.withOffset(
                if (left) -Robot.limbWidth / 2.0 else Robot.limbWidth / 2.0,
                Robot.upperArmHeight / 2.0,
                -Robot.limbWidth / 2.0
            ) {
                it.quaternionRotationFromEulerAngles(armAngleInDegrees, 0.0, 0.0, if (left) 1.0 else -1.0)
            }
        }

        fun lowerArm(left: Boolean) : Array<Coordinate> {
            return limb.withOffset(if (left) -Robot.limbWidth / 2.0 else Robot.limbWidth / 2.0, Robot.lowerArmHeight / 2.0, -Robot.limbWidth / 2.0) {
                it.quaternionRotationFromEulerAngles(armAngleInDegrees * 2.0, 0.0, 0.0, if (left) 1.0 else -1.0)
            }.translate(if (left) upperArmRotationXOffset else -upperArmRotationXOffset, upperArmRotationYOffset, 0.0)
        }
        fun hand(left: Boolean) : Array<Coordinate> {
            return limb.withOffset(if (left) -Robot.limbWidth / 2.0 else Robot.limbWidth / 2.0, Robot.handHeight / 2.0, -(Robot.handAndFootDepth) / 2.0) {
                it.quaternionRotationFromEulerAngles(armAngleInDegrees * 2.0, 0.0, 0.0, if (left) 1.0 else -1.0)
            }.translate(if (left) upperArmRotationXOffset + lowerArmRotationXOffset else -upperArmRotationXOffset - lowerArmRotationXOffset, lowerArmRotationYOffset + upperArmRotationYOffset, 0.0)
        }

        return when(phase) {
            Phase.Forward -> limb
            Phase.Side -> {
                return when (limbType) {
                    UpperLeftArm ->
                        upperArm(left = true)
                    UpperRightArm ->
                        upperArm(left = false)
                    LowerLeftArm ->
                        lowerArm(left = true)
                    LowerRightArm ->
                        lowerArm(left = false)
                    LeftHand ->
                        hand(left = true)
                    RightHand ->
                        hand(left = false)
                    else ->
                        limb
                }
            }
            Phase.BothLeft -> {
                return when (limbType) {
                    UpperLeftArm ->
                        upperArm(left = true)
                    UpperRightArm ->
                        upperArm(left = true)
                    LowerLeftArm ->
                        lowerArm(left = true)
                    LowerRightArm ->
                        lowerArm(left = true)
                    LeftHand ->
                        hand(left = true)
                    RightHand ->
                        hand(left = true)
                    else ->
                        limb
                }
            }
            Phase.BothRight -> {
                return when (limbType) {
                    UpperLeftArm ->
                        upperArm(left = false)
                    UpperRightArm ->
                        upperArm(left = false)
                    LowerLeftArm ->
                        lowerArm(left = false)
                    LowerRightArm ->
                        lowerArm(left = false)
                    LeftHand ->
                        hand(left = false)
                    RightHand ->
                        hand(left = false)
                    else ->
                        limb
                }
            }
        }


    }

    fun transformForward(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        // Rotating the arm the arm go up and forward, calculate by how much
        val upperArmRotationYOffset =
            (cos(Math.toRadians(armAngleInDegrees)) * Robot.upperArmHeight) - Robot.upperArmHeight
        val upperArmRotationZOffset = - (sin(Math.toRadians(armAngleInDegrees)) * Robot.upperArmHeight)

        val lowerArmRotationYOffset =
            (cos(Math.toRadians(armAngleInDegrees * 2.0)) * Robot.lowerArmHeight) - Robot.lowerArmHeight
        val lowerArmRotationZOffset = - (sin(Math.toRadians(armAngleInDegrees * 2.0)) * Robot.lowerArmHeight)

        return when(limbType) {
            UpperLeftArm, UpperRightArm ->
                limb.withOffset(Robot.limbWidth / 2.0, Robot.upperArmHeight / 2.0, -Robot.limbWidth / 2.0) {
                    it.quaternionRotationFromEulerAngles(armAngleInDegrees, -1.0, 0.0, 0.0)
                }
            LowerLeftArm, LowerRightArm ->
                limb.withOffset(Robot.limbWidth / 2.0, Robot.lowerArmHeight / 2.0, -Robot.limbWidth / 2.0) {
                    it.quaternionRotationFromEulerAngles(armAngleInDegrees * 2.0, -1.0, 0.0, 0.0)
                }.translate(0.0, upperArmRotationYOffset, upperArmRotationZOffset)

            LeftHand, RightHand ->
                limb.withOffset(Robot.limbWidth / 2.0, Robot.handHeight / 2.0, -(Robot.handAndFootDepth) / 2.0) {
                    it.quaternionRotationFromEulerAngles(armAngleInDegrees * 2.0, -1.0, 0.0, 0.0)
                }
                    .translate(0.0, upperArmRotationYOffset + lowerArmRotationYOffset, upperArmRotationZOffset + lowerArmRotationZOffset)
            else ->
                limb
        }
    }


}