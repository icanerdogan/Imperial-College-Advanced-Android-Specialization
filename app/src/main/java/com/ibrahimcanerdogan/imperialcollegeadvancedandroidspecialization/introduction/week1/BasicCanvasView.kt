package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.introduction.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class BasicCanvasView(context: Context) : View(context) {

    private var redPaint: Paint = Paint()

    init {
        redPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        redPaint.style = Paint.Style.STROKE
        redPaint.color = 0xffff000
        redPaint.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(10F, 30F, 200F, 200F, redPaint)
    }
}