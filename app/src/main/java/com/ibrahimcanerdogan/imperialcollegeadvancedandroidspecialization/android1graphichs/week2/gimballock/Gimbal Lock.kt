package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week2.gimballock

/*
We can perform a series
of transformations by multiplying the transformation
matrices together. When we do this,
we can come across a problem called a gimbal lock. Which is where
two or three planes aligned. So we lose the degrees
of freedom. Let me show you what I mean. For example, if we
would like to rotate an object of an angle
Alpha about the x-axis, and then rotate it with
Beta about the y-axis, we can derive that
transformation matrix by multiplying to a two
rotational matrix together. We can then perform
the rotation by multiplying this matrix with
the vertexes of the object. However, this rotation method has a problem coming
along as gimbal lock. For instance, when rotating
an object about the x, y and z axis, and the rotation about
the y-axis is 90 degrees, it will end up with
a gimbal lock problem where we lose
one degree of freedoms. So no matter if it
is Alpha or Beta, the object will only
rotate about the z-axis, and we will no longer be able
to rotate about the x-axis. This example illustrates how
gimbal lock is occurred. So the pink arrow
is rotating about the z-axis by adjusting
the angle Beta. The orange arrow is
supposed to rotate about the x-axis by
changing the angle Alpha. As you can see, it can only
rotate about the z-axis. We lost one degree of freedom, and this is the
gimbal lock problem. Gimbal lock occurs when
two or three things aligned. You can download
this example android app in the gimbal lock example
program and try it out. Let's try and simulate the gimbal lock problem
in our program. Over the android
studio project and timer task in the constructor
of the MyView class. In the timer task,
we want to spin the object about the x-axis. So we first define
the variable called angle. In the run function
of the timer task, we first translate the
original cube vertexes by two, two and two and sketch it 40 times in all three directions. Then rotate the cube about the x-axis with
the variable angle about the y-axis by 90 degrees and about the
z-axis by 25 degrees. We then translate the cube
to 200, 200 and zero. Afterwards we increment the value of the angle by 10 degrees. We schedule a timer task to trigger every 100 milliseconds. So this time it has object. It is supposed to spin the object about the x-axis in 10 degrees, and that occurred
every 100 milliseconds. When you run the program, you should see that
the cube is actually spinning around the z-axis even though the angle rotates
only varies in the x-axis. We have lost the ability to
rotate about the x-axis. What do you think will
happen if you swap the angle of rotation
between x and z-axis? If you do this, you
can see that the cube is again rotating
about the z-axis, but just in
a different direction. In the next lecture,
we'll look at using quaternions for rotation, which is the way to
avoid gimbal lock..
*/