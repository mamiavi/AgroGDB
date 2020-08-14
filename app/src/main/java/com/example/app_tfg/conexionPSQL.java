package com.example.app_tfg;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionPSQL {


    Connection conexion=null;


    public  Connection conexionBD(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            //CASAconexion = DriverManager.getConnection("jdbc:postgresql://192.168.0.14:5432/agroGDB", "postgres", "postgres");
            //MAMAconexion = DriverManager.getConnection("jdbc:postgresql://192.168.43.228:5432/agroGDB", "postgres", "postgres");
            conexion = DriverManager.getConnection("jdbc:postgresql://192.168.43.203:5432/agroGDB", "postgres", "postgres");

        }catch (Exception er){
            System.err.println("Error Conexion"+ er.toString());
        }
        return  conexion;
    }

    //Creamos la funcion para Cerrar la Conexion
    protected  void cerrar_conexion(Connection con)throws  Exception{
        con.close();
    }


}
