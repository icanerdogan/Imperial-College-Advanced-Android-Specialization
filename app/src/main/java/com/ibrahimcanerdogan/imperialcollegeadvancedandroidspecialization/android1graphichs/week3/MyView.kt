package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.content.Context
import android.graphics.Canvas
import android.view.View

class MyView(context: Context?) : View(context, null) {


    init {
        val thisview = this
//        Quarternion.assignment1(this)
        thisview.invalidate() //update the view
    }


    override fun onDraw(canvas: Canvas) {
        //draw objects on the screen
        super.onDraw(canvas)
//        ThreeDAffineTransformation.assignment2(canvas)
        ViewingAndProjection.videoDraw(canvas)
//        DrawHelper.drawCube(canvas, Quarternion.cube)

    }


}