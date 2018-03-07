package com.example.apocalypseth.ftpserver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTPClient;

import java.net.InetAddress;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private MyFTPClientFunction ftpclient = null;

    EditText password;
    EditText user;
    EditText host;

    FTPClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        host = (EditText) findViewById(R.id.host);
        user = (EditText) findViewById(R.id.usr);
        password = (EditText) findViewById(R.id.pwd);
        Button connect = (Button) findViewById(R.id.connect);
        FTPClient client= new FTPClient();

        //ftpclient = new MyFTPClientFunction();

        connect.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (isOnline(MainActivity.this)) {
                    //connectToFTPAddress();
                    FtpConnect();

                } else {
                    Toast.makeText(MainActivity.this,
                            "Please check your internet connection!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }





    private void FtpConnect(){
        final String h= host.getText().toString().trim();
        final String u= user.getText().toString().trim();
        final String p= password.getText().toString().trim();

        new Connection().execute(h, u, p);


    }
    private class Connection extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            try {
                FTPClient ftpClient = new FTPClient();
                ftpClient.connect(InetAddress.getByName(strings[0]));
                ftpClient.login(strings[1], strings[2]);

                System.out.println("status :: " + ftpClient.getStatus());

                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }

}
