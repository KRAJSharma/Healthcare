package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CartMedsActivity extends AppCompatActivity {

    private  String[][] packages={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tv;
    ListView lst;

    Button btncheckout,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_meds);
        btncheckout=findViewById(R.id.buttonCMCartCheckout);
        btnback=findViewById(R.id.buttonCMCartBack);
        ListView lst = findViewById(R.id.CMCartList);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        Database db = new Database(getApplicationContext(),"healthcare",null,1);

        float totalAmount= 0;
        ArrayList dbData= db.getCartData(username,"lab");
        Toast.makeText(getApplicationContext(), ""+dbData, Toast.LENGTH_SHORT).show();
        packages = new String[dbData.size()][];
        for (int i= 0; i<packages.length; i++){
            packages[i]= new String[5];
        }
        for (int i=0;i<dbData.size();i++){
            String arrData =dbData.get(i).toString();
            String[] strdata = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0]=strdata[0];
            packages[i][0]= "Cost : "+ strdata[1]+"/-";
            totalAmount = totalAmount +Float.parseFloat(strdata[1]);
        }

        tv= findViewById(R.id.textViewCMCartTotalCost);
        tv.setText("Total Cost : " + totalAmount);

        list = new ArrayList();
        for (int i =0; i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        lst.setAdapter(sa);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartMedsActivity.this,BuyMedicineActivity.class));
            }
        });
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CartMedsActivity.this,BookMedActivity.class);
                //it.putExtra("Name",tv.getText());
                it.putExtra("Price",tv.getText());
                startActivity(it);
            }
        });
    }
}