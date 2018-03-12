package com.example.apocalypseth.ftpserver;

import android.app.Activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.Serializable;


public class SecondActivity extends Activity {

    Connection c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //Connection c = (Connection) getIntent().getSerializableExtra("connection");
        c=new Connection();
  /*      try {
            System.out.println(c.ftpClient. getStatus("/"));
        } catch (IOException e) {
            e.printStackTrace();
        } */



        TableLayout statusTableLayout = (TableLayout)findViewById(R.id.table);
        for(int i=0;i<2;i++)
        {
            LinearLayout statusTableRow = new LinearLayout(this);
            statusTableRow.setId(i);
            statusTableRow.setOrientation(LinearLayout.VERTICAL);
            TextView productsTextView = new TextView(this);
            productsTextView.setText("product name:"+i);
            statusTableRow.addView(productsTextView);
            //statusTableRow.setBackgroundColor(Color.BLACK);


            for(int j=0;j<2;j++)
            {
                RelativeLayout statusRelativelayout = new RelativeLayout(this);

                RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                rl.setMargins(5, 0, 16, 0);
                rl.addRule(RelativeLayout.ALIGN_LEFT);
                TextView label = new TextView(this);
                label.setId(j);
                label.setText("abcd:"+j);
                label.setLayoutParams(rl);
                statusRelativelayout.addView(label);
                statusTableRow.addView(statusRelativelayout);

            }
            statusTableLayout.addView(statusTableRow);
        }


    }

}
