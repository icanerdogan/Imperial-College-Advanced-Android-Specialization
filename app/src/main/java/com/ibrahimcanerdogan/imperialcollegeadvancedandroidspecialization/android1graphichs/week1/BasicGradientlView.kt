package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.view.View

class BasicGradientlView(context: Context): View(context) {

    /*
    - Stroke
    - Fill
    - Stroke & Fill
    - Gradient Fill
    - Texture Fill
    */

    private val myLines = Path()

    // val linearGradient = LinearGradient(x_0, y_0, x_4,y_4, Color.BLUE, Color.RED, Shader.TileMode.MIRROR)
    private val linearGradient = LinearGradient(10F, 10F, 100F,100F, Color.BLUE, Color.RED, Shader.TileMode.MIRROR)
    private val gradientPaint = Paint()

    init {
        // myLines.moveTo(x_0, y_0)
        // myLines.lineTo(x_1, y_1)
        // myLines.lineTo(x_2, y_2)
        // myLines.lineTo(x_3, y_3)
        // myLines.lineTo(x_4, y_4)
        myLines.close()

        gradientPaint.style = Paint.Style.FILL
        gradientPaint.shader = linearGradient
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(myLines, gradientPaint)
    }
}