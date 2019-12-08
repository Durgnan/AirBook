package com.example.airbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button login;
    ConstraintLayout coordinatorLayout;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        coordinatorLayout = findViewById(R.id.container);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = username.getText().toString().trim();
                if (user==null || user == "" || pass == "" || pass == null)
                {
                                Toast.makeText(getApplicationContext(),"Please fill the empty fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                   if(user.equals("root") && pass.equals("root"))
                   {

                       Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(Login.this,Dashboard.class));
                       finish();
                   }

                }
            }
        });
    }
}
