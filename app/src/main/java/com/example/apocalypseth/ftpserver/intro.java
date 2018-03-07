package com.example.apocalypseth.ftpserver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by ApocalypseTH on 15/02/2018.
 */

public class intro extends Activity {

    private static int SPLASH_TIME_OUT=2500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent i = new Intent(intro.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
