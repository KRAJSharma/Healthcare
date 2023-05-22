package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private  String[][] packages={
            {"Lisinopril","","","","100"},
            {"Paracetamol","","","","200"},
            {"Amlodipine.","","","","300"},
            {"Dolo-350","","","","100"},
            {"Crocin-350","","","","100"},
            {"Strepsils","","","","300"},
            {"Atorvastatin","","","","200"},
            {"Metformi","","","","150"},
            {"Simvastatin","","","","200"},
            {"Omeprazole","","","","300"}
    };
    private String[] packageName={
            "Pesudo text 1\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 2\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 3\n"+
                    "Pesudo text"+"Pesudo text",
            "Pesudo text 4\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 5\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 6\n"+
                    "Pesudo text"+"Pesudo text",
            "Pesudo text 7\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 8\n"
                    +"Pesudo text"+"Pesudo text",
            "Pesudo text 9\n"+
                    "Pesudo text"+"Pesudo text",
            "Pesudo text 10\n"+
                    "Pesudo text"+"Pesudo text",
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGotoCart, btnback;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        btnback=findViewById(R.id.buttonBMBack);
        btnGotoCart=findViewById(R.id.buttonBMGotoCart);
        listView = findViewById(R.id.BMList);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cons Fees" + packages[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        // ListView lst = findViewById(R.id.LTList);
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,DetailMedicineActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packageName[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartMedsActivity.class));
            }
        });
    }
}