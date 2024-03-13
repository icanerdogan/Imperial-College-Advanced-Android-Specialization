package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week3.robot.DancingRobotView

class MainActivity : AppCompatActivity() {
    private var mMyView: View? = null //a custom view for drawing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main);
        supportActionBar!!.hide() //hide the title bar
        mMyView = DancingRobotView(this)
        setContentView(mMyView)
    }
}