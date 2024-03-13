package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot

import android.content.Context
import android.graphics.Canvas
import android.view.View
import java.util.*
import kotlin.concurrent.timerTask

class DancingRobotView(context: Context?) : View(context, null)  {

    val view = this
    val timer = Timer()

    val task = timerTask {
        Robot.update()
        view.invalidate()
    }

    init {
        timer.scheduleAtFixedRate(task, 100L, 2L)
    }
    

    override fun onDraw(canvas: Canvas) {
//        DrawHelper.drawHeightLine(canvas, lineY, screenCenterX * 2.0)
        super.onDraw(canvas)
        Robot.draw(canvas)
    }
}