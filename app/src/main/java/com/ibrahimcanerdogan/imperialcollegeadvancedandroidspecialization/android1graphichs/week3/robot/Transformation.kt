package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot

import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate

interface Transformation {
    fun transform(limbType: LimbType, limb: Array<Coordinate>) : Array<Coordinate>
}