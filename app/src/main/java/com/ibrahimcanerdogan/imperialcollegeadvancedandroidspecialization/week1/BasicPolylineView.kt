package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class BasicPolylineView(context: Context): View(context) {

    val greenPaint = Paint()
    val myLines = Path()

    init {
        // myLines.moveTo(x_0, y_0)
        // myLines.lineTo(x_1, y_1)
        // myLines.lineTo(x_2, y_2)
        // myLines.lineTo(x_3, y_3)
        // myLines.lineTo(x_4, y_4)

        greenPaint.setARGB(255, 0, 255, 0)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawPath(myLines, greenPaint)
    }
}