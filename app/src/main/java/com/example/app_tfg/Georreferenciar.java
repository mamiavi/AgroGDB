package com.example.app_tfg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Georreferenciar extends AppCompatActivity {

    private LocationManager gestor;
    Double lat, lon, precision=100.0;
    private ArrayList<Double> listaLat= new ArrayList<>();
    private ArrayList<Double> listaLon= new ArrayList<>();
    private static conexionPSQL con= new conexionPSQL();
    TextView textoLatitud;
    TextView textoLongitud;
    TextView textoPrecision;
    String coordenadas=null;
    Button btnAñadir;
    Variables_Globales va= Variables_Globales.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_georreferenciar);
        btnAñadir=findViewById(R.id.buttonAñadir);
        btnAñadir.setEnabled(false);
        textoLatitud= findViewById(R.id.textLatitud);
        textoLongitud= findViewById(R.id.textLongitud);
        textoPrecision= findViewById(R.id.textPrecision);

        RegistrarLocalizacion();
        final Bundle extras=getIntent().getExtras();


        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!(extras ==null)){
                if (extras.get("Feature").equals("Point")) {

                     lat=Double.parseDouble(textoLatitud.getText().toString());
                     lon=Double.parseDouble(textoLongitud.getText().toString());
                    precision=Double.parseDouble(textoPrecision.getText().toString());
                    btnAñadir.setAlpha((float) 0.5);
                    btnAñadir.setEnabled(false);
                }
                if(extras.get("Feature").equals("Polygon")){

                    double lat=Double.parseDouble(textoLatitud.getText().toString());
                    double lon=Double.parseDouble(textoLongitud.getText().toString());
                    listaLat.add(lat);
                    listaLon.add(lon);

                }
            }
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Punto añadido correctamente", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });

        Button btnFinalizar =findViewById(R.id.buttonFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //try {
                    if(extras.get("Feature").equals("Polygon")){

                        for(int i=0;i<listaLat.size();i++){
                            if(coordenadas==null){
                                coordenadas=listaLon.get(i)+" "+listaLat.get(i);
                            }
                            coordenadas=coordenadas+","+listaLon.get(i)+" "+listaLat.get(i);
                        }
                        coordenadas=coordenadas+","+listaLon.get(0)+" "+listaLat.get(0);
                    }
                    GuardarSalir();
                //} catch (SQLException e) {
                    //e.printStackTrace();
                //}

                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                "Entidad añadida correctamente", Toast.LENGTH_SHORT);

                toast2.show();

            }
        });

    }



    private void RegistrarLocalizacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
        }

        gestor = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { }
        gestor.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3 * 1000, 1, new LocalizaciónActualizada());//3 segundos

    }

    private class LocalizaciónActualizada implements LocationListener {//Todos los métodos se escriben solos

        @Override
        public void onLocationChanged(Location location) {

            textoLatitud.setText(String.valueOf(location.getLatitude()));

            textoLongitud.setText(String.valueOf(location.getLongitude()));

            textoPrecision.setText(String.valueOf(location.getAccuracy()));

            precision=Double.parseDouble(String.valueOf((location.getAccuracy())));
            //CONDICION DE PRECISIÓN A 5 metros
            if(precision<=5) btnAñadir.setEnabled(true);

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    public void GuardarSalir(){
        Bundle extras=getIntent().getExtras();
        Integer tlfpersonal=va.get_tlfpersonal();
        String denominacion=va.getDenominacion();
        System.out.println(va.get_tlfpersonal()+va.getDenominacion());
        try{
        Connection connection=con.conexionBD();



        switch (extras.get("tabla").toString()) {
            case "balsa":
                String balsa_nombre=extras.getString("balsa_nombre");
                Integer balsa_year=Integer.parseInt(extras.get("balsa_ano").toString());
                Integer capacidad=Integer.parseInt(extras.get("balsa_capacidad").toString());
                String estado=extras.getString("balsa_estado");
                String materiales=extras.getString("balsa_materiales");
                String problemas=extras.getString("balsa_problemas");
                Boolean filtracioes=extras.getBoolean("balsa_filtraciones");
                String funcion=extras.getString("balsa_funcion");

                connection.prepareStatement("insert into public.\"BALSAS\"(\"Nombre\",\"Year\",\"Capacidad\"," +
                        "\"Estado\",\"Materiales\",\"Filtraciones\"," +
                        "\"Problemas Funcionamiento\",\"EERR\",\"num_telf\",\"Funcion\",\"geom\") " +
                        "VALUES (\'"+balsa_nombre+"\',"+balsa_year+","+capacidad+",\'"+estado+"\'," +
                        "\'"+materiales+"\',"+filtracioes+",\'"+problemas+"\',\'"+denominacion+"\',"+tlfpersonal+",\'"+funcion+"\'," +
                        " st_geomfromtext('polygon (("+coordenadas+"))',4326)"+")").executeUpdate();
                break;


            case "cabezal":
                String cabezales_nombre=extras.getString("cabezales_nombre");
                String cabezales_tipo=extras.getString("cabezales_tipo");
                Integer cabezales_dimensiones=Integer.parseInt(extras.get("cabezales_dimensiones").toString());
                connection.prepareStatement("insert into public.\"CABEZALES\"(\"Nombre\",\"Dimensiones\",\"Tipo Construccion\",\"EERR\",\"num_telf\",\"geom\") VALUES (\'"+cabezales_nombre+"\',"+cabezales_dimensiones+",\'"+cabezales_tipo+"\',\'"+denominacion+"\',"+tlfpersonal+", st_geomfromtext('point ("+lon+" "+lat+")',4326)"+")").executeUpdate();
                break;


            case "impulsiones":
                String impulsiones_nombre=extras.getString("impulsiones_nmbre");
                Integer impulsiones_year=Integer.parseInt(extras.get("impulsiones_year").toString());
                String impulsiones_tarifa=extras.getString("impulsiones_tarifa");
                Integer impulsiones_potencia=Integer.parseInt(extras.get("impulsiones_potenia").toString());
                String impulsiones_tipo=extras.getString("impulsiones_tipo");
                Integer impulsiones_caudal=Integer.parseInt(extras.getString("impulsiones_caudal"));
                Integer impulsiones_altura=Integer.parseInt(extras.getString("impulsiones_altura"));
                connection.prepareStatement("insert into public.\"IMPULSIONES\" (\"Nombre\",\"Year\",\"Tipo Tarifa Electrica\",\"Potencia Contratada\", \"Tipo de Bomba\",\"Caudal Nominal\",\"Altura Manométrica\",\"EERR\",\"num_telf\",\"geom\") VALUES (\'"+impulsiones_nombre+"\',"+impulsiones_year+",\'"+impulsiones_tarifa+"\', "+impulsiones_potencia+",\'"+impulsiones_tipo+"\',"+impulsiones_caudal+","+impulsiones_altura+",\'"+denominacion+"\',\'"+tlfpersonal+", st_geomfromtext('point ("+lon+" "+lat+")',4326)"+")").executeUpdate();
                break;


            case "otros":
                String otros_nombre=extras.get("otros_nombre").toString();
                Integer otros_year=Integer.parseInt(extras.get("otros_year").toString());
                String otros_description=extras.get("otros_desc").toString();

                connection.prepareStatement("insert into public.\"OTROS\"(\"Nombre\",\"Year\",\"Descripcion\",\"EERR\",\"num_telf\",\"geom\") VALUES (\'"+otros_nombre+"\',"+otros_year+",\'"+otros_description+"\',\'"+denominacion+"\',"+tlfpersonal+","+"st_geomfromtext('point ("+lon+" "+lat+")',4326)"+")").executeUpdate();
                break;

            case "parcela":
                String tipo_cultivo=extras.get("tipo_cultivo").toString();
                String sistema_riego=extras.get("sistema_riego").toString();


                connection.prepareStatement("insert into public.\"PARCELAS\"(\"Tipo Cultivo\",\"Sistema de Riego\",\"EERR\",\"num_telf\",\"geom\") VALUES (\'"+tipo_cultivo+"\',\'"+sistema_riego+"\',\'"+denominacion+"\',"+tlfpersonal+","+"st_geomfromtext('polygon (("+coordenadas+"))',4326)"+")").executeUpdate();
                break;

            case "pozo":
                String pozo_nombre=extras.get("pozo_nombre").toString();
                Integer pozo_year=Integer.parseInt(extras.get("pozo_year").toString());
                String pozo_concesion=extras.get("pozo_concesion").toString();
                Double pozo_profundidad=Double.parseDouble(extras.get("pozo_profundidad").toString());
                Double pozo_diametro=Double.parseDouble(extras.get("pozo_diametro").toString());
                Double pozo_nivel=Double.parseDouble(extras.get("pozo_nivel").toString());
                String pozo_tarifa=extras.get("pozo_tarifa").toString();
                Integer pozo_potencia=Integer.parseInt(extras.get("pozo_potencia").toString());
                String pozo_bomba=extras.get("pozo_bomba").toString();
                Integer pozo_caudal=Integer.parseInt(extras.get("pozo_caudal").toString());
                Integer pozo_altura=Integer.parseInt(extras.get("pozo_altura").toString());
                Boolean pozo_variador=extras.getBoolean("pozo_variador");

                connection.prepareStatement("insert into public.\"POZOS\" (\"Nombre\",\"Year\",\"Codigo Concesion Administrativa\",\"Profundidad sondeo\",\"Diametro sondeo\",\"Nivel Piezometrico\",\"Tipo Tarifa Electrica\",\"Potencia Contratada\", \"Tipo Bomba\",\"Caudal Nominal\",\"Altura manometrica\",\"Variador\",\"EERR\",\"num_telf\",\"geom\") VALUES (\'"+pozo_nombre+"\',"+pozo_year+","+pozo_concesion+","+pozo_profundidad+","+pozo_diametro+","+pozo_nivel+",\'"+pozo_tarifa+"\', "+pozo_potencia+",\'"+pozo_bomba+"\',"+pozo_caudal+","+pozo_altura+","+pozo_variador+",\'"+denominacion+"\',"+tlfpersonal+", st_geomfromtext('point ("+lon+" "+lat+")',4326)"+")").executeUpdate();

                break;


        }
        }catch (Exception er){
            Toast toast =
                    Toast.makeText(getApplicationContext(),
                            "Error en la conexión", Toast.LENGTH_SHORT);

            toast.show();
        }


        Intent i = new Intent(this,InventariadoActivity.class);
        startActivity(i);
    }

}


