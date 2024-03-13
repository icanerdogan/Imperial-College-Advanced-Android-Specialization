package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations

import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.quaternionRotationFromEulerAngles
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Transformation


class DebugSideView : Transformation {
    override fun transform(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        return limb.quaternionRotationFromEulerAngles(90.0, 0.0, 1.0, 0.0)
    }
}