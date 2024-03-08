package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.introduction.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.graphics.Shader
import android.view.View

class BasicAffineTransformation(context: Context) : View(context) {

    /*
    - Translation: Move to shape
    - Rotation: Rotate a shape
    - Scaling: Scale a shape
    - Shear
    */
    private val myLines = Path()
    private val linearGradient = LinearGradient(10F, 10F, 100F,100F, Color.BLUE, Color.RED, Shader.TileMode.MIRROR)
    private val gradientPaint = Paint()
    private val blackPaint = Paint()

    private val points = arrayOf<Point>(
        Point(50, 300),
        Point(150, 400),
        Point(180, 240),
        Point(240, 420),
        Point(300, 200)
    )

    init {
        // myLines.moveTo(x_0, y_0)
        // myLines.lineTo(x_1, y_1)
        // myLines.lineTo(x_2, y_2)
        // myLines.lineTo(x_3, y_3)
        // myLines.lineTo(x_4, y_4)

        gradientPaint.style = Paint.Style.FILL
        gradientPaint.shader = linearGradient
        blackPaint.style = Paint.Style.STROKE
        blackPaint.setColor(Color.BLACK)
    }

    private fun updatePath(newPoints: Array<Point>) {
        myLines.reset()
        myLines.moveTo(newPoints[0].x.toFloat(), newPoints[0].y.toFloat())
        for (i in 1..newPoints.size) {
            myLines.lineTo(newPoints[i].x.toFloat(), newPoints[i].y.toFloat())
        }
        myLines.close()
    }


    private fun affineTransformation(vertices: Array<Point>, matrix: Array<DoubleArray>): Array<Point> {
        val result: Array<Point> = arrayOf()

        for(i in 0..vertices.size) {
            val t = (matrix[0][1] * vertices[i].x + matrix[0][1] * vertices[i].y + matrix[0][2]).toInt()
            val u = (matrix[1][0] * vertices[i].x + matrix[1][1] * vertices[i].y + matrix[1][2]).toInt()
            result[i] = Point(t, u)
        }
        return result
    }

    private fun translate(input: Array<Point>, px: Int, py: Int) : Array<Point> {
        val matrix: Array<DoubleArray> = arrayOf()

        matrix[0][0] = 1.0
        matrix[0][1] = 0.0
        matrix[0][2] = px.toDouble()
        matrix[1][0] = 0.0
        matrix[1][1] = 1.0
        matrix[1][2] = py.toDouble()
        matrix[2][0] = 0.0
        matrix[2][1] = 0.0
        matrix[2][2] = 1.0

        return affineTransformation(input, matrix)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(myLines, gradientPaint)
        val newPoints = translate(points, 20, 40)
        updatePath(newPoints)
        canvas.drawPath(myLines, blackPaint)
    }
}