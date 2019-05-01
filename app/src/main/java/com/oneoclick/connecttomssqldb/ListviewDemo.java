package com.oneoclick.connecttomssqldb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListviewDemo extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        listView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("android0");
        arrayList.add("android1");
        arrayList.add("android2");
        arrayList.add("android3");
        arrayList.add("android4");
        arrayList.add("android5");
        arrayList.add("android6");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewDemo.this,"clicked item:  "+ position +"  " +arrayList.get(position).toString()
                        ,Toast.LENGTH_SHORT).show();
            }
        });


    }//void
}//main
