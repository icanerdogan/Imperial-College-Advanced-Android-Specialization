package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class BasicPolygonView(context: Context) : View(context) {

    private val redFillPaint = Paint()
    private val blackPaint = Paint()
    private val myLines = Path()

    init {
        // myLines.moveTo(x_0, y_0)
        // myLines.lineTo(x_1, y_1)
        // myLines.lineTo(x_2, y_2)
        // myLines.lineTo(x_3, y_3)
        // myLines.lineTo(x_4, y_4)
        myLines.close()

        redFillPaint.style = Paint.Style.FILL
        redFillPaint.setARGB(255, 255, 0, 0)
        blackPaint.style = Paint.Style.STROKE
        blackPaint.setColor(Color.BLACK)

    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawPath(myLines, redFillPaint)
        canvas.drawPath(myLines, blackPaint)
    }
}