package com.example.alertfamily2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityRegistrar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Metodo de Cancelar:
        Button btncancelar = findViewById(R.id.btnCancelar);
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(cancelar);
            }
        });

        //Metodo de Guardar:

    }
}
