package com.oneoclick.connecttomssqldb;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FindMember extends AppCompatActivity {
    ConnectionClass connectionClass;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_member);

        connectionClass = new ConnectionClass();

        final Button btn1 = (Button) findViewById(R.id.buttonFind);
        final TextView txtName = (TextView) findViewById(R.id.textViewName);
        final TextView txtLastName = (TextView) findViewById(R.id.textViewLastName);
        final TextView edtTxtName = (TextView) findViewById(R.id.editTextName);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        message = "not connect!!!";
                        Toast.makeText(FindMember.this, message, Toast.LENGTH_SHORT);
                    } else {
                        String userid = edtTxtName.getText().toString();
                        String query = "select * from User1 where UserId = '" + userid + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if (rs.next() == false) {
                            message = "Record not found!!!";
                            Toast.makeText(FindMember.this, message, Toast.LENGTH_SHORT);
                        } else {
                            txtName.setText(rs.getString("UserFname"));
                            txtLastName.setText(rs.getString("UserLname"));
                        }//if rs
                    }//if con
                } catch (Exception ex) {
                    message = " Exceptions";
                    Toast.makeText(FindMember.this, message, Toast.LENGTH_SHORT);
                }//try catch
            }
        });
    }//void
}//main