package com.example.app_tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ActivarInfoActivity(View vista){
        Intent i = new Intent(this,InfoActivity.class);
        startActivity(i);
    }

    public void ActivarInventariadoActivity(View vista){

        Intent i = new Intent(this, InventariadoActivity.class);
        startActivity(i);
    }

    public void ActivarPerfilActivity(View vista){
        Intent i = new Intent(this, PerfilActivity.class);
        startActivity(i);
    }

    public void SalirApp(View vista){
        finish();
    }
}
