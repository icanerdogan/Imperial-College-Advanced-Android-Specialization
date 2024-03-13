package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

//*********************************************
//* Homogeneous coordinate in 3D space
class Coordinate {
    var x: Double
    var y: Double
    var z: Double
    var w: Double

    constructor() { //create a coordinate with 0,0,0
        x = 0.0
        y = 0.0
        z = 0.0
        w = 1.0
    }

    constructor(x: Double, y: Double, z: Double, w: Double) { //create a Coordinate object
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    fun normalise() : Coordinate { //to keep it as a homogeneous coordinate -> divide the coordinate with w and set w=1
        if (w != 0.0) { //ensure that w!=0
            x /= w
            y /= w
            z /= w
            w = 1.0
        } else w = 1.0
        return this
    }
}