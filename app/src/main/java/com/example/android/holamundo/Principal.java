package com.example.android.holamundo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;
    private Bundle b;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);
        i = new Intent(this,Saludo.class);
        b = new Bundle();
        res = this.getResources();
    }

    public void saludar(View v){
        if (validar()){
            String nomb, apell;
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);

            i.putExtras(b);

            startActivity(i);
        }
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(res.getString(R.string.error_1));
            //Toast.makeText(getApplicationContext(),"Digite por favor el nombre", Toast.LENGTH_SHORT.);
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError(res.getString(R.string.error_2));
            return false;
        }
        return true;
    }
}
