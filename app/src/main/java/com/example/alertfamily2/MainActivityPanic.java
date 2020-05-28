package com.example.alertfamily2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPanic extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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

        //Boton Usuario:
        ImageButton btnmenu = findViewById(R.id.ImgBtnUsuario);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(),MainActivityMostrar.class);
                startActivity(menu);
            }
        });
    }

    //metodo seleccionar contacto:
    private void seleccionarContacto(){
        Intent seleccionarcontactoInten = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        seleccionarcontactoInten.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(seleccionarcontactoInten,pick_contac_request);
    }

    // Metodo Menu popup:
    public void showPopup(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()) {
            case R.id.item1:
                Intent mostrar = new Intent(getApplicationContext(),MainActivityMostrar.class);
                startActivity(mostrar);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Intent cai = new Intent(getApplicationContext(),MainActivityCai_1.class);
                startActivity(cai);
                return true;
            case R.id.item4:
                Toast.makeText(this, "Cerrar Cesion", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
