package com.cursodekotlin.loginejemploauth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {


    private CardView btnSalir;

    private TextView txtUser;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        btnSalir = findViewById(R.id.exitBtn);
        //txtUser =  findViewById(R.id.textUserName);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();


        if(mUser != null){
            String name = mUser.getDisplayName();
     //       txtUser.setText(name);
        }

      btnSalir.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(this, login.class));

        });



    }//End onCreate


}