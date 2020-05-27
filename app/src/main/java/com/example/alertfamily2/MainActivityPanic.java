package com.example.alertfamily2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPanic extends AppCompatActivity {

    //variable contactos:
    static final int pick_contac_request=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);

        // Boton de panico:
        Button btnpanico = findViewById(R.id.btnPanic);
        btnpanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarContacto();
            }
        });
    }

    //metodo seleccionar contacto:
    private void seleccionarContacto(){
        Intent seleccionarcontactoInten = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        seleccionarcontactoInten.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(seleccionarcontactoInten,pick_contac_request);
    }
}
