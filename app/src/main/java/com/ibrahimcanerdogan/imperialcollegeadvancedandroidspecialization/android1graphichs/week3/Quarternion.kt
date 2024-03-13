package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.view.View
import java.util.*
import kotlin.concurrent.timerTask

object Quarternion {

    val timer = Timer()
    var angle = 45.0
    var cube = DrawHelper.cube_vertices
        .translate(2.0, 2.0, 2.0)
        .scale(40.0, 40.0, 40.0)

    fun assignment1(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .quaternionRotationFromEulerAngles(
                    angle,
                    0.0, 1.0 ,1.0
                )
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }

}