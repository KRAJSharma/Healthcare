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

public class LoginActivity extends AppCompatActivity {
    EditText edUsername , edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edPassword = findViewById(R.id.editTextLoginPassword);
        edUsername = findViewById(R.id.editTextLoginUsername);
        tv = findViewById(R.id.textView4);
        btn = findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = edUsername.getText().toString();
                String Password = edPassword.getText().toString();
                Database db= new Database(getApplicationContext(),"Healthcare",null,1);
                if (Username.length()==0 || Password.length()==0) {
                    Toast.makeText(LoginActivity.this, "Fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (db.login(Username,Password)==1) {
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username",Username);
                        editor.apply();
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}