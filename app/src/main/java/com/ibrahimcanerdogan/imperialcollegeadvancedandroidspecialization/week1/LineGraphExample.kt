package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.week1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.view.View
import androidx.core.graphics.scaleMatrix

class LineGraphExample(context: Context): View(context) {

    private var lineGraph: Path = Path()
    private val redPaint = Paint()

    init {
        val viewHeight = resources.displayMetrics.heightPixels - 70
        val viewWidth = resources.displayMetrics.widthPixels

        val plotData = arrayOf(11,29,10,20,12,5,31,24,21,13)

        lineGraph = createLineGraph(plotData, viewWidth, viewHeight)

        redPaint.style = Paint.Style.STROKE
        redPaint.setColor(Color.RED)
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

    private fun createLineGraph(input: Array<Int>, width: Int, height: Int) : Path {
        var ptArray: Array<Point> = arrayOf()
        var minValue = 999999
        var maxValue = -999999

        for (i in 0..input.size) {
            ptArray[i] = Point(i, input[i])
            minValue = Math.min(minValue, input[i])
            maxValue = Math.max(maxValue, input[i])
        }

        ptArray = translate(ptArray, 0, -minValue)
        val yScale = height / (maxValue - minValue).toDouble()
        val xScale = width / (input.size - 1).toDouble()
        //ptArray = scale(ptArray, xScale, yScale)
        val result = Path()
        result.moveTo(ptArray[0].x.toFloat(), ptArray[0].y.toFloat())

        for (i in 1..ptArray.size) {
            result.lineTo(ptArray[i].x.toFloat(), ptArray[i].y.toFloat())
        }
        return result
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(lineGraph, redPaint)
    }
}