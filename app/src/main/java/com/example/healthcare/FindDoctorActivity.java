package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class FindDoctorActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit", "Hospital Address : Pimpri" ,"EXP: 5yrs","Mobile No.:9327363632","600"},
                    {"Doctor Name : Ajay", "Hospital Address : Pimiwq" ,"EXP: 15yrs","Mobile No.:8327363632","900"},
                    {"Doctor Name : vijay", "Hospital Address : oasdos" ,"EXP: 20yrs","Mobile No.:92778963632","300"},
                    {"Doctor Name : sanjay", "Hospital Address : lsaos" ,"EXP: 5yrs","Mobile No.:9234363632","500"},
                    {"Doctor Name : gajni", "Hospital Address : iisias" ,"EXP: 25yrs","Mobile No.:93273435432","300"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajit", "Hospital Address : Pimpri" ,"EXP: 5yrs","Mobile No.:9327363632","600"},
                    {"Doctor Name : Ajay", "Hospital Address : Pimiwq" ,"EXP: 15yrs","Mobile No.:8327363632","900"},
                    {"Doctor Name : vijay", "Hospital Address : oasdos" ,"EXP: 20yrs","Mobile No.:92778963632","300"},
                    {"Doctor Name : sanjay", "Hospital Address : lsaos" ,"EXP: 5yrs","Mobile No.:9234363632","500"},
                    {"Doctor Name : gajni", "Hospital Address : iisias" ,"EXP: 25yrs","Mobile No.:93273435432","300"}
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Ajit", "Hospital Address : Pimpri" ,"EXP: 5yrs","Mobile No.:9327363632","600"},
                    {"Doctor Name : Ajay", "Hospital Address : Pimiwq" ,"EXP: 15yrs","Mobile No.:8327363632","900"},
                    {"Doctor Name : vijay", "Hospital Address : oasdos" ,"EXP: 20yrs","Mobile No.:92778963632","300"},
                    {"Doctor Name : sanjay", "Hospital Address : lsaos" ,"EXP: 5yrs","Mobile No.:9234363632","500"},
                    {"Doctor Name : gajni", "Hospital Address : iisias" ,"EXP: 25yrs","Mobile No.:93273435432","300"}
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Ajit", "Hospital Address : Pimpri" ,"EXP: 5yrs","Mobile No.:9327363632","600"},
                    {"Doctor Name : Ajay", "Hospital Address : Pimiwq" ,"EXP: 15yrs","Mobile No.:8327363632","900"},
                    {"Doctor Name : vijay", "Hospital Address : oasdos" ,"EXP: 20yrs","Mobile No.:92778963632","300"},
                    {"Doctor Name : sanjay", "Hospital Address : lsaos" ,"EXP: 5yrs","Mobile No.:9234363632","500"},
                    {"Doctor Name : gajni", "Hospital Address : iisias" ,"EXP: 25yrs","Mobile No.:93273435432","300"}
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Ajit", "Hospital Address : Pimpri" ,"EXP: 5yrs","Mobile No.:9327363632","600"},
                    {"Doctor Name : Ajay", "Hospital Address : Pimiwq" ,"EXP: 15yrs","Mobile No.:8327363632","900"},
                    {"Doctor Name : vijay", "Hospital Address : oasdos" ,"EXP: 20yrs","Mobile No.:92778963632","300"},
                    {"Doctor Name : sanjay", "Hospital Address : lsaos" ,"EXP: 5yrs","Mobile No.:9234363632","500"},
                    {"Doctor Name : gajni", "Hospital Address : iisias" ,"EXP: 25yrs","Mobile No.:93273435432","300"}
            };
    TextView tv;
    HashMap<String,String> item;
    ArrayList list;
    String[][] doctor_details={};
    SimpleAdapter sa;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit= findViewById(R.id.cardBack);
        CardView dentist= findViewById(R.id.cardDentist);
        CardView dietician= findViewById(R.id.cardDietician);
        CardView familyphysician= findViewById(R.id.cardFamilyPhysician);
        CardView surgeon= findViewById(R.id.cardSurgeon);
        CardView cardiologist = findViewById(R.id.cardCardiologist);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });

    }
}