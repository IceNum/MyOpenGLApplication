package com.opengl.myopenglapplication.activity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.opengl.myopenglapplication.OpenGLRenderer;
import com.opengl.myopenglapplication.OpenGLRenderer3D;

/**
 * Created by fotoable on 2017/6/2.
 */

public class Picture3DActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // (NEW)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // (NEW)


        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new OpenGLRenderer3D());
        setContentView(view);
    }

    @Override
    public void onClick(View v) {

    }
}
