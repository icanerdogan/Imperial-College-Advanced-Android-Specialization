package com.ibrahimcanerdogan.imperialcollegeadvancedandroidspecialization.android1graphichs.week2.quaternion

/*
One solution to avoid gimbal lock is to use quaternion
for rotation. Instead of rotating
in three planes, quaternion rotates about an axis. It's a faster solution
as it only needs to store 4 floating points for rotation and requires
less computation. Because of this, it also
produces smoother rotation. Before explaining
what is quaternion, let's refresh our memory
on complex numbers. A Complex Number can be
represented in a form of a plus bi where a and b are real numbers and i is an imaginary number equal
to a squareroot of -1. We can rotate a
complex number by multiplying the number
with unit vector, cosine theta plus i sine theta, it is effectively
a 2D rotation. However, it won't work in 3D, modifying to 3D vectors
we lead to problems. The order of the more
complex number in multiplications could
yield different results. I times j does not
equal to j times i. And a multiplication can
produce zero which leads to the divide
by zero problem. The solution is quaternion introduced by Hamilton in 1843, it defined three fundamental
quaternion units; i, j, and k, which are
imaginary numbers. It works like three
vectors in 3D space. The muliplication of
two quaternion units works like cross products
with two vectors. For example, i
times j equals to k and j times i equals
to minus k. It is also like a unit vector where i squared plus j squared
plus k squared is equal to -1 and equal
to i times j times k. A quaternion is
generally represented as w plus xi plus yj plus zk, where w is a real number and i, j, k are the
quaternion components. It's just like complex number a + bi or we can represent
it as a coordinate (w, x, y, z) or (w, v), where w is the vector
in the imaginary space. For rotation, we need to know how to multiply two
quaternions together. So how does the
multiplication work? So let q1 and q2 be
two quaternions. When multiplying
the two quaternions together, remember that q1 times q2
does not equal to q2 times q1 and the result quaternions can be calculated
using these equations. You can refer to the reading on quaternion multiplication and rotational matrix for details on how to derive these equations. Similar to the complex
numbers showed before, we can use unit quaternion
for 3D rotation. So let theta over 2, be the angle of rotation then w will equal to cosine theta over 2 and the vector v will equal to sine theta over
2 times the vector R. R is the rotational axis which the vertex is rotated about. Then the quaternion can be
defined as a cosine theta over 2 and sine theta
over 2 times r. To perform rotation, we also need to find the inverse
of the quaternion q; which is simply
the complex conjugate of the quaternion q. To perform the rotation, let p as a 3D coordinate
and q as a unit quaternion. We can convert p into
quaternion by simply setting w equals 0 and p equal
to xi plus yj plus zk. The 3D rotation of
the p by q can be calculated as q times p
times the inverse of q. So the first
multiplication of q is basically rotating
the coordinates by the theta over 2 counter-clockwise and then the multiplication
of the inverse of q is basically rotating the coordinates by another theta
over 2 counter-clockwise. As rotations through the two
quaternions cancel each other, we end up rotating
about the 3D axis. Let's look at a example, let p be the point at (3, 4, 2), and lets rotate the coordinate by 60 degrees about the y-axis. So the r is equal to [0, 1, 0]. The unit quaternion
can be calculated as cosine theta over 2 and
sine theta over 2 times r. We can then use the quaternion multiplication
functions to calculate the values of q times p
times the inverse of q. The result is 0, 3.232, 4 and -1.598. However, the calculations
appear to be quite intensive. We can simplify
the quaternion rotation into a transformation matrix. So by using this
transformation matrix M, we don't need to
calculate the q times p times the inverse
of q any more. Instead, to rotate point p, we simply multiply p with
this transformation matrix. So let's try our example again. But this time, we use
the transformation matrix M, by multiplying
the transformation matrix M with the homogeneous coordinates p, you get the same
result as before. This is an example showing how we can use quaternion to
rotate an object in 3D. The orange arrow is
the axis of rotation and the purple arrow spins
around the orange arrow. You can download
this Android app from the reading quaternion
example program and try it out in
your Android emulator
*/