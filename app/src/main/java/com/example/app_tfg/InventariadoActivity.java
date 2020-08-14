package com.example.app_tfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class InventariadoActivity extends Activity {
    public Variables_Globales va = Variables_Globales.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inventariar);
        System.out.println(va.get_tlfpersonal()+va.getDenominacion());
    }



    public void FichaCabezal(View vista){
        Intent i = new Intent(this,FichaCabezal.class);
        startActivity(i);
    }

    public void FichaPozo(View vista){
        Intent i = new Intent(this,FichaPozo.class);
        startActivity(i);
    }

    public void FichaImpulsiones(View vista){
        Intent i = new Intent(this,FichaImpulsiones.class);
        startActivity(i);
    }

    public void FichaOtros(View vista){
        Intent i = new Intent(this,FichaOtros.class);
        startActivity(i);
    }

    public void FichaParcela(View vista){
        Intent i = new Intent(this,FichaParcela.class);
        startActivity(i);
    }

    public void FichaBalsa(View vista){
        Intent i = new Intent(this,FichaBalsa.class);
        startActivity(i);
    }
}
