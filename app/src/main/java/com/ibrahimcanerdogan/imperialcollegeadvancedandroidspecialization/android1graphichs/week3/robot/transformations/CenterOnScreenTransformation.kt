package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.transformations

import android.content.res.Resources
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.LimbType
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Robot.totalHeight
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.Transformation
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.translate

class CenterOnScreenTransformation : Transformation {
    private val screenCenterX = Resources.getSystem().displayMetrics.widthPixels / 2.0
    private val screenCenterY = Resources.getSystem().displayMetrics.heightPixels / 2.0

    override fun transform(limbType: LimbType, limb: Array<Coordinate>): Array<Coordinate> {
        return limb.translate(screenCenterX, screenCenterY - (totalHeight / 4.0), 0.0)
    }
}