package com.example.alertfamily2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
