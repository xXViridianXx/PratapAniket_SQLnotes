package com.example.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MyContactApp", "MainActivity: setting up the layout");
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editText_name);

        myDb = new DatabaseHelper(this);
        Log.d("MyContactApp", "MainActivity: instantiated databaseHelper");
    }


    public void addData (View view)
    {
        Log.d("MyContactApp", "MainActivity: Add contact button pressed");
        boolean isInserted = myDb.insertData(editName.getText().toString());

        if (isInserted == true)
        {
            Toast.makeText(MainActivity.this,"Boom, added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Failed", Toast.LENGTH_SHORT).show();
        }
    }



    public void  viewData(View view)
    {
        Cursor res = myDb.getAllData();

        //put log.d's here
        if(res.getCount() == 0)
        {
            showMessage("Error", "No Data found in database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            //Append res columns to the buffer - see the StringBuffer and Cursrs's API's
            buffer.append("ID: " + res.getString(0) + "\n");
            buffer.append("Name: " + res.getString(1) + "\n");
            buffer.append("Phone: " + res.getString(2) + "\n");
            buffer.append("Address: " + res.getString(3) + "\n");
        }

        showMessage("Data", buffer.toString());
    }





public void showMessage(String title, String message)
{
    //put log d

    Log.d("MyContactApp", "MainActivity: Message shown");
    AlertDialog.Builder builder = new AlertDialog.Builder((this));
    builder.setCancelable((true));
    builder.setTitle(title);
}
}