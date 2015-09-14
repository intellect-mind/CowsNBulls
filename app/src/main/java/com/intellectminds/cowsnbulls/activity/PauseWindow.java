package com.intellectminds.cowsnbulls.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.intellectminds.cowsnbulls.R;

/**
 * Created by DELL on 10-09-2015.
 */
public class PauseWindow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int height = dm.heightPixels;
        int width = dm.widthPixels;

        getWindow().setLayout((int)(height*.40),(int)(width*.75));
    }
}
