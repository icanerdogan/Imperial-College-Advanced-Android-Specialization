package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

object DrawHelper {

    private val redPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG) //paint object for drawing the lines
    private val bluePaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG) //paint object for drawing the lines
    val cube_vertices : Array<Coordinate> =
        arrayOf(
            Coordinate(-1.0, -1.0, -1.0, 1.0),
            Coordinate(-1.0, -1.0, 1.0, 1.0),
            Coordinate(-1.0, 1.0, -1.0, 1.0),
            Coordinate(-1.0, 1.0, 1.0, 1.0),
            Coordinate(1.0, -1.0, -1.0, 1.0),
            Coordinate(1.0, -1.0, 1.0, 1.0),
            Coordinate(1.0, 1.0, -1.0, 1.0),
            Coordinate(1.0, 1.0, 1.0, 1.0),
        ).scale(0.5, 0.5, 0.5) // scale to 1 by 1 by 1 cube


    init {
        //create the paint object
        redPaint.style = Paint.Style.STROKE //Stroke
        redPaint.color = Color.RED
        redPaint.strokeWidth = 2f
        bluePaint.style = Paint.Style.STROKE //Stroke
        bluePaint.color = Color.BLUE
        bluePaint.strokeWidth = 2f
    }



    fun drawHeightLine(canvas: Canvas, y : Double, screenWidth: Double) {
        canvas.drawLine(
            0f,
            y.toFloat(),
            screenWidth.toFloat(),
            y.toFloat(),
            bluePaint
        )
    }

    fun drawCube(canvas: Canvas, vertices: Array<Coordinate>, color : Int)  {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.STROKE //Stroke
        paint.color = color
        paint.strokeWidth = 2f
        drawCube(canvas, vertices, paint)
    }

    fun drawCube(canvas: Canvas, vertices: Array<Coordinate>, paint : Paint = redPaint) { //draw a cube on the screen
        drawLinePairs(canvas, vertices, 0, 1, paint)
        drawLinePairs(canvas, vertices, 1, 3, paint)
        drawLinePairs(canvas, vertices, 3, 2, paint)
        drawLinePairs(canvas, vertices, 2, 0, paint)
        drawLinePairs(canvas, vertices, 4, 5, paint)
        drawLinePairs(canvas, vertices, 5, 7, paint)
        drawLinePairs(canvas, vertices, 7, 6, paint)
        drawLinePairs(canvas, vertices, 6, 4, paint)
        drawLinePairs(canvas, vertices, 0, 4, paint)
        drawLinePairs(canvas, vertices, 1, 5, paint)
        drawLinePairs(canvas, vertices, 2, 6, paint)
        drawLinePairs(canvas, vertices, 3, 7, paint)
    }

    private fun drawLinePairs(
        canvas: Canvas,
        vertices: Array<Coordinate>,
        start: Int,
        end: Int,
        paint: Paint
    ) { //draw a line connecting 2 points
        //canvas - canvas of the view
        //points - array of points
        //start - index of the starting point
        //end - index of the ending point
        //paint - the paint of the line
        canvas.drawLine(
            vertices[start].x.toFloat(),
            vertices[start].y.toFloat(),
            vertices[end].x.toFloat(),
            vertices[end].y.toFloat(),
            paint
        )
    }

    fun drawAndFillCube(canvas: Canvas, vertices: Array<Coordinate>, color: Int) { //draw a cube on the screen
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL_AND_STROKE //Stroke
        paint.color = color
        paint.strokeWidth = 2f

        drawFace(
            canvas,
            vertices,
            paint,
            0,
            1,
            3,
            2
        )
        drawFace(
            canvas,
            vertices,
            paint,
            1,
            5,
            7,
            3
        )
        drawFace(
            canvas,
            vertices,
            paint,
            4,
            5,
            6,
            7
        )
        drawFace(
            canvas,
            vertices,
            paint,
            0,
            4,
            6,
            2
        )
        drawFace(
            canvas,
            vertices,
            paint,
            2,
            3,
            7,
            6
        )
        drawFace(
            canvas,
            vertices,
            paint,
            0,
            4,
            5,
            1
        )
    }

    fun drawFace(canvas: Canvas,
                 vertices: Array<Coordinate>,
                 paint: Paint,
                 v1: Int,
                 v2: Int,
                 v3: Int,
                 v4: Int,
    ) {
        val p = Path()
        p.moveTo(vertices[v1].x.toFloat(), vertices[v1].y.toFloat())
        p.lineTo(vertices[v2].x.toFloat(), vertices[v2].y.toFloat())
        p.lineTo(vertices[v3].x.toFloat(), vertices[v3].y.toFloat())
        p.lineTo(vertices[v4].x.toFloat(), vertices[v4].y.toFloat())
        canvas.drawPath(p, paint)
    }

    fun drawText(canvas: Canvas, text: String) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        redPaint.style = Paint.Style.FILL //Stroke
        redPaint.color = Color.RED
        redPaint.strokeWidth = 1f
        redPaint.textSize = 50f

        canvas.drawText(text, 50f, 50f, redPaint)
    }
}