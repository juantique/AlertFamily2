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

public class MainActivityCai_1 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai);

        //Boton Usuario:
        ImageButton btnusuario = findViewById(R.id.ImgBtnUsuarioCai);
        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usuario = new Intent(getApplicationContext(), MainActivityMostrar.class);
                startActivity(usuario);
            }
        });

        //Boton Mapa:
        ImageButton btnmapa = findViewById(R.id.ImageButtonMapa);
        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa = new Intent(getApplicationContext(), MapsActivityCai.class);
                startActivity(mapa);
            }
        });

    }

    // Metodo Menu popup:
    public void showPopupmap (View v){
        PopupMenu popupMenuMapa = new PopupMenu(this, v);
        popupMenuMapa.setOnMenuItemClickListener(this);
        popupMenuMapa.inflate(R.menu.popup_menu);
        popupMenuMapa.show();
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
