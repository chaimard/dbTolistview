package com.oneoclick.connecttomssqldb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Toast;

import java.util.ArrayList;


public class SelelectDataAddToListview extends AppCompatActivity {

    ConnectionClass connectionClass;
    ListView listView;
    ArrayAdapter adapter;
    String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selelect_data_add_to_listview);

        connectionClass = new ConnectionClass();
        listView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();
        final Button btn1 = (Button) findViewById(R.id.button1);

//        Toast.makeText(SelelectDataAddToListview.this, "Test", Toast.LENGTH_SHORT);
//
//        try {
//                    Connection con = connectionClass.CONN();
//
//                    if (con == null) {
//                        message = " Error in connection with SQL Server";
//                        Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);
//                    } else {
//                        String query = "select * from User1";
//                        Statement stmt = con.createStatement();
//                        ResultSet rs = stmt.executeQuery(query);
//                        if (rs.next()) {
//                        //    String username = rs.getString("UserFname")+" "+rs.getString("UserLname");
//                          while (rs.next()){
//                              arrayList.add(rs.getString("UserFname") + " " + rs.getString("UserLname"));
//                          }
//                            adapter = new ArrayAdapter(SelelectDataAddToListview.this, android.R.layout.simple_list_item_1,arrayList );
//                            listView.setAdapter(adapter);
//
//                        } else {
//                            message = "No data " ;
//                            Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);
//                        }
//                    }
//
//                } catch (Exception ex) {
//
//                    message = " Exceptions";
//                    Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);
//                }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try {
                    Connection con = connectionClass.CONN();

                    if (con == null) {
                        message = " Error in connection with SQL Server";
                        Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);
                    } else {
                        String query = "select * from User1";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);


                        if (rs.next()==false) {
                            message = "ResultSet is empty ... " ;
                            Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);

                        } else {

                            do {
                                arrayList.add(rs.getString("UserFname") + " " + rs.getString("UserLname"));
                            } while (rs.next());

// This logic is missed the first row.
//                            while (rs.next()){
//                                arrayList.add(rs.getString("UserFname") + " " + rs.getString("UserLname"));
//                            }

                            adapter = new ArrayAdapter(SelelectDataAddToListview.this, android.R.layout.simple_list_item_1,arrayList );
                            listView.setAdapter(adapter);

                        }

                    }

                } catch (Exception ex) {

                    message = " Exceptions";
                    Toast.makeText(SelelectDataAddToListview.this, message, Toast.LENGTH_SHORT);
                }
            }
        });





    }//void
}//main
