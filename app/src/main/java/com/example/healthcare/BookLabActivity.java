package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookLabActivity extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lab);
        edname=findViewById(R.id.editTextLBFullname);
        edaddress=findViewById(R.id.editTextLBAddress);
        edcontact=findViewById(R.id.editTextLBContact);
        edpincode=findViewById(R.id.editTextLBPincode);
        booking=findViewById(R.id.buttonLBRegister);

        Intent intent=getIntent();
        String[] price= intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(""));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(getApplicationContext(), "Booking is sucessfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookLabActivity.this,HomeActivity.class));

            }
        });
    }
}