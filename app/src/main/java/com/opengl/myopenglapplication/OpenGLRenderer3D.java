package com.opengl.myopenglapplication;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.opengl.myopenglapplication.mesh.Cube;
import com.opengl.myopenglapplication.mesh.Group;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.R.attr.angle;

/**
 * Created by fotoable on 2017/6/2.
 */

 public class OpenGLRenderer3D implements GLSurfaceView.Renderer {

    Cube square = new Cube(1,1,1);
    Group group = new Group();
    /**
     * 这个方法中主要用来设置一些绘制时不常变化的参数，比如：背景色，是否打开 z-buffer等。
     * @param gl
     * @param config
     */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background color to black ( rgba ).
        gl.glClearColor(0.0f, 1.0f, 1.0f, 0.5f);
        // Enable Smooth Shading, default not really needed.
        gl.glShadeModel(GL10.GL_SMOOTH);
        // Depth buffer setup.
        gl.glClearDepthf(1.0f);
        // Enables depth testing.
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // The type of depth testing to do.
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);
    }

    /**
     * 如果设备支持屏幕横向和纵向切换，这个方法将发生在横向<->纵向互换时。此时可以重新设置绘制的纵横比率。
     * @param gl
     * @param width
     * @param height
     */

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);
        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset the projection matrix
        gl.glLoadIdentity();
        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f,
                (float) width / (float) height,
                0.1f, 100.0f);
        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // Reset the modelview matrix
        gl.glLoadIdentity();
    }

    /**
     * 定义实际的绘图操作。
     * @param gl
     */
    @Override
    public void onDrawFrame(GL10 gl) {
        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT |
                GL10.GL_DEPTH_BUFFER_BIT);
        // Replace the current matrix with the identity matrix
        gl.glLoadIdentity();
        // Translates 4 units into the screen.
        gl.glTranslatef(0, 0, -10);


        // SQUARE A
        // Save the current matrix.
        gl.glPushMatrix();
        // Rotate square A counter-clockwise.
        gl.glRotatef(angle, 0.5f, 0.5f, 0.5f);
        // Draw square A.
        square.draw(gl);
        // Restore the last matrix.
        gl.glPopMatrix();
//
//        // SQUARE B
//        // Save the current matrix
//        gl.glPushMatrix();
//        // Rotate square B before moving it,
//        //making it rotate around A.旋转
//        gl.glRotatef(-angle, 0.5f, 0, 1);
//        // Move square B.平移
//        gl.glTranslatef(2, 0, 0);
//        // Scale it to 50% of square 缩放A
//        gl.glScalef(.5f, .5f, .5f);
//        // Draw square B.
//        square.draw(gl);
////        gl.glPopMatrix();
//
//        // SQUARE C
//        // Save the current matrix
//        gl.glPushMatrix();
//        // Make the rotation around B
//        gl.glRotatef(-angle, 0, 0, 1);
//        gl.glTranslatef(2, 0, 0);
//        // Scale it to 50% of square B
//        gl.glScalef(.5f, .5f, .5f);
//        // Rotate around it's own center.
//        gl.glRotatef(angle*10, 0, 0, 1);
//        // Draw square C.
//        square.draw(gl);
//
//        gl.glPopMatrix();
//        gl.glPopMatrix();


    }
}
