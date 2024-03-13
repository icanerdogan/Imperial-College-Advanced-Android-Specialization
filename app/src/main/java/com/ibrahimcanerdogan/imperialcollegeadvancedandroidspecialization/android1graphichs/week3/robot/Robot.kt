package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot

import android.graphics.Canvas
import android.graphics.Color
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.DrawHelper
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.ArmAnimation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.CenterOnScreenTransformation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.LegAnimation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.MoveLimbToPositionInBodyTransformation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.ScaleTransformation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations.ViewAngleAnimation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType.*

object Robot {
    val scalingFactor = 0.60
    val offsetZ = 0.0
    val offsetY = 0.0 * scalingFactor
    val headSize = 240.0 * scalingFactor
    val headY = offsetY + (headSize / 2.0)
    val neckHeight = 60.0 * scalingFactor
    val neckY = headY + (headSize / 2.0) + (neckHeight / 2.0)
    val bodyDepth = 120 * scalingFactor
    val bodyHeight = 600.0 * scalingFactor
    val bodyWidth = 480.0 * scalingFactor
    val bodyY = neckY + (neckHeight / 2.0) + (bodyHeight / 2.0)
    val waistHeight =  160.0 * scalingFactor
    val waistY = bodyY + (bodyHeight / 2.0) + (waistHeight / 2.0)

    val limbWidth = 160.0 * scalingFactor
    val upperArmHeight = 240.0 * scalingFactor
    val upperArmY = bodyY - (bodyHeight / 2.0) + (upperArmHeight / 2.0)
    val lowerArmHeight = 320.0 * scalingFactor
    val lowerArmY = upperArmY + (upperArmHeight / 2.0) + (lowerArmHeight / 2.0)
    val handHeight = 80.0 * scalingFactor
    val handAndFootDepth = limbWidth + (100.0 * scalingFactor)
    val handY = lowerArmY + (lowerArmHeight / 2.0) + (handHeight / 2.0)

    val upperLegHeight = 240.0 * scalingFactor
    val upperLegY = waistY + (waistHeight / 2.0) + (upperLegHeight / 2.0)
    val lowerLegHeight = 320.0 * scalingFactor
    val lowerLegY = upperLegY + (upperLegHeight / 2.0) + (lowerLegHeight / 2.0)
    val footHeight = 80.0 * scalingFactor
    val footY = lowerLegY + (lowerLegHeight / 2.0) + (footHeight / 2.0)


    val leftArmX = - (bodyWidth / 2.0) - (limbWidth / 2.0)
    val rightArmX = + (bodyWidth / 2.0) + (limbWidth / 2.0)
    val leftLegX = - (bodyWidth / 2.0) + (limbWidth / 2.0)
    val rightLegX = + (bodyWidth / 2.0) - (limbWidth / 2.0)

    val totalHeight = (headY + neckY + bodyY + upperLegY + lowerLegY + footY) * scalingFactor

    val danceSpeedFactor = 2L

    val transformations = listOf(
        ScaleTransformation(),
        LegAnimation(),
        ArmAnimation(),
        MoveLimbToPositionInBodyTransformation(),
        ViewAngleAnimation(),
//        DebugSideView(),
        CenterOnScreenTransformation()
    )

    fun update() {
        transformations.forEach { when(it) {
            is Animation ->
                it.update(System.currentTimeMillis() * danceSpeedFactor)
        } }
    }

    fun draw(canvas: Canvas) {
        val cube = DrawHelper.cube_vertices
        values().map { limbType ->
            Pair(transformations.fold(cube) { limb, transformation -> transformation.transform(limbType, limb) }, limbType)
        }
            // sort by z value, so that the limbs with the limbs that are the closest are drawn last
            // look specifically at the closest 4 vertices (probably the closest face)
            .sortedBy { it.first.map { c -> c.z }.sorted().takeLast(4).sum() }
            .forEach { limbAndLimbType ->
            DrawHelper.drawAndFillCube(canvas, limbAndLimbType.first, limbToColor(limbAndLimbType.second))
        }
    }

    private fun limbToColor(limbType: LimbType) : Int {
        return when(limbType) {
            Head -> Color.BLUE
            Neck -> Color.MAGENTA
            Body -> Color.RED
            Waist -> Color.MAGENTA
            UpperLeftArm, UpperRightArm -> Color.BLUE
            LowerLeftArm, LowerRightArm -> Color.GREEN
            LeftHand, RightHand -> Color.CYAN
            UpperLeftLeg, UpperRightLeg ->  Color.BLUE
            LowerLeftLeg, LowerRightLeg -> Color.GREEN
            LeftFoot, RightFoot -> Color.RED
        }
    }

}