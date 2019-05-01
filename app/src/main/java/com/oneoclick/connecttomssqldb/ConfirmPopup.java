package com.oneoclick.connecttomssqldb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class ConfirmPopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_popup);
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);

        // Button1
        final Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                adb.setTitle("Confirm?");
                adb.setMessage("Plese Confirm");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        // TODO Auto-generated method stub
                        Toast.makeText(ConfirmPopup.this,"Your Click OK. " ,
                                Toast.LENGTH_LONG).show();
                    }
                });
                adb.show();

            }
        });


    }//void

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //getMenuInflater().inflate(R.menu.activity_confirm_popup,menu);
//        getMenuInflater().inflate(R.menu.activity_confirm_popup, menu);
//
//        return true;
//    }
}//main
