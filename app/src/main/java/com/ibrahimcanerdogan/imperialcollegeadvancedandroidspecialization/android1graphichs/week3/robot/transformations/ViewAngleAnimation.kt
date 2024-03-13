package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations

import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.quaternionRotationFromEulerAngles
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Animation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.AnimationHelper
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType

class ViewAngleAnimation : Animation {
    var counter = 0L

    override fun update(counter : Long) {
        this.counter = counter % 6000L
    }

    private val viewAngleInDegrees : Double
        get() = AnimationHelper.interpolateBackAndForth(counter, 6000L, 90.0) + 180.0 - 45.0


    override fun transform(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        return limb.quaternionRotationFromEulerAngles(viewAngleInDegrees, 0.0, 1.0, 0.0)
    }
}

