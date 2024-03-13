package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.graphics.Canvas

object ViewingAndProjection {
    var cube =
        DrawHelper.cube_vertices


    fun videoDraw(canvas: Canvas) {
        val near = 1.0
        val far = 1.1
        val left = -1.0
        val right = 1.0
        val top = -1.0
        val bottom = 1.0
        val fov = 90.0


        cube =
            DrawHelper.cube_vertices
                .translate(2.0, 2.0, 2.0)
                .perspectiveProjection(near, far, left, right, top, bottom)
//                .perspectiveProjectionDirect(near, far, fov, left, right, top, bottom)
                .scale(40.0, 40.0, 40.0)
                .translate(200.0, 200.0, 0.0)

        DrawHelper.drawCube(
            canvas,
            cube
        )
    }
}