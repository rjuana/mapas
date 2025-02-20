package com.jhon.mismapas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle extras = getIntent().getExtras();
        int Maloka =extras.getInt("uno");
        int MundoAv =extras.getInt("dos");
        int Monserrat =extras.getInt("tres");
        int Salitremag =extras.getInt("cuatro");
        // Add a marker in Sydney and move the camera
        if (Maloka == 1 ) {
            LatLng maloka = new LatLng(4.6550752, -74.1115463 );
            mMap.addMarker(new MarkerOptions().position(maloka).title("Marker in Maloka"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(maloka));
        } else if (MundoAv == 2) {
            LatLng mundoa = new LatLng(4.622468, -74.1385367 );
            mMap.addMarker(new MarkerOptions().position(mundoa).title("Marker in mundo Aventura").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mundoa));
        } else if (Monserrat == 3) {
            LatLng monserrat = new LatLng(4.6056507, -74.0555395 );
            mMap.addMarker(new MarkerOptions().position(monserrat).title("Marker in Monserrate").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(monserrat));
        }
        else if (Salitremag == 4) {
            LatLng salitremag = new LatLng(4.6648196, -74.0941646 );
            mMap.addMarker(new MarkerOptions().position(salitremag).title("Marker in Salitre Magico").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(salitremag));
        }
    }



}