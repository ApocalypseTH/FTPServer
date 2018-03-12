package com.example.apocalypseth.ftpserver;

import android.content.Intent;
import android.os.AsyncTask;

import org.apache.commons.net.ftp.FTPClient;

import java.io.Serializable;
import java.net.InetAddress;

public class Connection extends AsyncTask<String, Void, Void> {

    public static FTPClient ftpClient=new FTPClient();

    @Override
    protected Void doInBackground(String... strings) {
        try {
            ftpClient.connect(InetAddress.getByName(strings[0]));
            boolean answer = ftpClient.login(strings[1], strings[2]);



            if(answer){

            }
            else{

            }

            //System.out.println("status :: " + ftpClient.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}