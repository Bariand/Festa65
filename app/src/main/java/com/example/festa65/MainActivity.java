package com.example.festa65;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng LOCAL_FESTA = new LatLng(-31.7682, -52.3371); // Praça Coronel Pedro Osório
    private ViewPager2 viewPager;
    private int[] images = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3}; // coloque suas imagens no drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura o carrossel de imagens
        viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(images);
        viewPager.setAdapter(adapter);

        // Configura o mapa do Google Maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(LOCAL_FESTA).title("Local da Festa"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LOCAL_FESTA, 15f));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }
}