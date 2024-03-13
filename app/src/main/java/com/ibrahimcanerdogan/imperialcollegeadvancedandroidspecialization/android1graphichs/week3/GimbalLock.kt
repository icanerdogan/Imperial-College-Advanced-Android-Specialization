package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.view.View
import java.util.*
import kotlin.concurrent.timerTask

object GimbalLock {

    val timer = Timer()
    var angle = 45.0
    var cube = DrawHelper.cube_vertices
        .translate(2.0, 2.0, 2.0)
        .scale(40.0, 40.0, 40.0)

    fun video(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateX(angle)
                .rotateY(90.0)
                .rotateZ(0.0)
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }

    var positionX = 0.0
    var goRight = true
    fun exampleTimer(view : View) {
        val task = timerTask {
            if (positionX + 80.0 >= view.width) {
                goRight = false
            }
            if (positionX < 0.0) {
                goRight = true
            }

            if (goRight) {
                cube = cube.translate(1.0, 0.0, 0.0)
                positionX += 1.0
            } else {
                cube = cube.translate(-1.0, 0.0, 0.0)
                positionX -= 1.0
            }

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 2)
    }

    fun assignment1(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateZ(angle)
                .rotateX(90.0)
                .rotateY(25.0)
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }

    fun assignment2A(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateX(90.0)
                .rotateZ(angle)
                .rotateY(60.0)
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }


    fun assignment2B(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateZ(60.0)
                .rotateY(90.0)
                .rotateX(angle)
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }

    fun assignment2C(view : View) {
        val task = timerTask {
            cube = DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateX(angle)
                .rotateZ(60.0)
                .rotateY(90.0)
                .translate(200.0, 200.0, 0.0)

            view.invalidate()
            angle = (angle + 10) % 360
        }

        timer.scheduleAtFixedRate(task, 100, 100)
    }

}