package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername , edPassword , edEmail , edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        edEmail= findViewById(R.id.editTextRegEmail);
        edUsername = findViewById(R.id.editTextRegUsername);
        tv = findViewById(R.id.textViewExistingUser);
        btn = findViewById(R.id.buttonRegister);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String ConfirmPassword = edConfirm.getText().toString();
                String Password = edPassword.getText().toString();
                Database db= new Database(getApplicationContext(),"Healthcare",null,1);
                if (Username.length() == 0|| Email.length()==0 || Password.length()==0 || ConfirmPassword.length()==0){
                    Toast.makeText(RegisterActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Password.compareTo(ConfirmPassword)==0){
                        if (isValid(Password)){
                            db.register(Username,Email,Password);
                            Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Password must be of 8 digit ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Password is not same", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public static boolean isValid(String password) {

        if (password.length() < 8) {
            return false;
        } else {
            char c;
            int count = 1;
            for (int i = 0; i < password.length() - 1; i++) {
                c = password.charAt(i);
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                } else if (Character.isDigit(c)) {
                    count++;
                    if (count < 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}