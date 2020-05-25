package com.example.alertfamily2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variable de boton de imagen del mapa de google:
    //private ImageButton btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Metodo boton de ingresar:
        Button btingresar = findViewById(R.id.btnIngresar);
        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.txtPass)).getText().toString();
                String pass = ((EditText) findViewById(R.id.txtPass)).getText().toString();
                if (usuario.equals("admin")&& pass.equals("admin"))
                {
                    Toast.makeText(getApplicationContext(), "Usario correcto", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
        });

        //Metodo boton registrar:
        Button btnregistrar = findViewById(R.id.btnRegistrar);
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar = new Intent(getApplicationContext(),MainActivityRegistrar.class);
                startActivity(registrar);
            }
        });
/*
        // LOGICA DE TIPO IMAGENBUTTON, MAPA DE GOOGLE:
        btnMapa = (ImageButton) findViewById(R.id.imageButtonMapa);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent(getApplicationContext(),MapsActivityCai.class);
                startActivity(mapa);
            }
        });*/
    }
/*
     CREAR EL MENU POPUP:
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener();
    }
*/
}
