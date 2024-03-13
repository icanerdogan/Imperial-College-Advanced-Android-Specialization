package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.graphics.Canvas
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.Coordinate
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.DrawHelper
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.rotateX
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.rotateY
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.rotateZ
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.scale
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.shear
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.translate

object ThreeDAffineTransformation {

    fun video(canvas: Canvas) {
        DrawHelper.drawCube(
            canvas,
            DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .rotateY(45.0)
                .rotateX(45.0)
        )
    }

    fun assignment1(canvas: Canvas) {
        val draw_cube_vertices: Array<Coordinate> =
            DrawHelper.cube_vertices //the vertices for drawing a 3D cube
                .rotateZ(80.0)
                .rotateY(30.0)
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
        DrawHelper.drawCube(canvas, draw_cube_vertices)
    }

    fun assignment2(canvas: Canvas) {
        val draw_cube_vertices: Array<Coordinate> =
            DrawHelper.cube_vertices //the vertices for drawing a 3D cube
                .translate(2.0, 2.0, 2.0)
                .scale(40.0, 40.0, 40.0)
                .shear(2.0, 1.0)
        DrawHelper.drawCube(canvas, draw_cube_vertices)
    }
}