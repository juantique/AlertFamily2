package com.example.alertfamily2;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityCai extends FragmentActivity implements OnMapReadyCallback {

    //DECLARACION DE VARIABLES DE NAVEGACION BOTONES:
    private Button btn_Hibrido,btn_Normal,btn_Satelital,btn_Terreno;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_cai);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Accion de los botones:
        btn_Hibrido = (Button) findViewById(R.id.btnHibrido);
        btn_Normal = (Button) findViewById(R.id.btnNormal);
        btn_Satelital = (Button) findViewById(R.id.btnSatelital);
        btn_Terreno = (Button) findViewById(R.id.btnTerreno);
    }

    //DECLARACION DE METODOS BOTONES DEL MAPA:
    public void CambiarHibrido(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void CambiarNormal(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void CambiarSatelital(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void CambiarTerreno(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // AGREGAR UNA MARCA DE CIUDADES:
        // CIUDAD DE BOGOTA:
        LatLng bogota = new LatLng(4.59808, 74.0760439);
        mMap.addMarker(new MarkerOptions().position(bogota).draggable(true).title("Ciudad de Bogotá, Colombia").snippet("Bogotá, metropoli cultural y social").icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)));

        // CIUDAD DE MEDELLIN:
        LatLng medellin = new LatLng(6.2443382, -75.573553);
        mMap.addMarker(new MarkerOptions().position(medellin).draggable(true).title("Ciudad de Medellin, Colombia").snippet("Medellin, ciudad de la eterna primavera").icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)));

        // CIUDAD DE CALI:
        LatLng cali = new LatLng(3.4517923, -76.5324943);
        mMap.addMarker(new MarkerOptions().position(cali).draggable(true).title("Ciudad de Cali, Colombia").snippet("Cali, ciudad salsera de Colombia").icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)));

        // CIUDAD DE IBAGUE:
        LatLng ibague = new LatLng(4.4446595, -75.2430012);
        mMap.addMarker(new MarkerOptions().position(ibague).draggable(true).title("Ciudad de Ibague, Colombia").snippet("Ibague, ciudad musical del mundo").icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicacion)));

        //MUESTRA EN EL MAPA LA CAMARA:
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota,7));

        //Agrega los controles de zoom o menos.
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //localizacion en el mapa:
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}


/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */