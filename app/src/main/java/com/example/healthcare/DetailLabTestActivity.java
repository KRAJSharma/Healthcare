package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailLabTestActivity extends AppCompatActivity {

    TextView tvpackagename,tvtotalcost;
    EditText eddetails;
    Button btn ,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lab_test);
        tvpackagename=findViewById(R.id.titleDLTTitle);
        tvtotalcost=findViewById(R.id.textViewDLTotalCost);
        eddetails=findViewById(R.id.EditTextMultiline);
        btn=findViewById(R.id.buttonDLTBack);
        btn2=findViewById(R.id.buttonDLTGotoCart);

        eddetails.setKeyListener(null);

        Intent intent= getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        eddetails.setText(intent.getStringExtra("text2"));
        tvtotalcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailLabTestActivity.this,LabTestActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvpackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Prodcut ALready Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(), "Record inserted into cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DetailLabTestActivity.this,LabTestActivity.class));
                }

            }
        });
    }
}