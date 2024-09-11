//package com.map;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.location.Location;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
//import com.google.android.gms.maps.GoogleMap;
//import com.facebook.react.ReactActivity;
//import com.google.android.libraries.places.api.model.Place;
//import com.google.android.libraries.places.widget.Autocomplete;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.maps.model.LatLng;
//import android.widget.FrameLayout;
//
//public class MainActivity extends ReactActivity {
//
//    private LatLng currentLatLng;
//    private GoogleMap googleMap;
//
//    private ActivityResultLauncher<Intent> autoCompleteLauncher;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//         autoCompleteLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            result -> {
//                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
//                    Place place = Autocomplete.getPlaceFromIntent(result.getData());
//                    LatLng searchLatLng = place.getLatLng();
//                    if (searchLatLng != null && currentLatLng != null) {
//                            googleMap.addMarker(new MarkerOptions().position(searchLatLng).title(place.getName()));
//                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(searchLatLng, 12));
//
//                            // Calculate and show distance
//                            float[] results = new float[1];
//                            Location.distanceBetween(currentLatLng.latitude, currentLatLng.longitude,
//                                    searchLatLng.latitude, searchLatLng.longitude, results);
//
//                            float distanceInMeters = results[0];
//                            // Toast.makeText(getContext(), "Distance: " + distanceInMeters / 1000 + " km", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        );
//          CustomView customView = new CustomView(this, autoCompleteLauncher);
//           setContentView(customView);
//           Log.d("AutoCompleter",autoCompleteLauncher.toString());
//
//        // Optionally, add the CustomView to a FrameLayout or other parent layout
////        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
////            FrameLayout.LayoutParams.MATCH_PARENT,
////            FrameLayout.LayoutParams.MATCH_PARENT
////        );
////        customView.setLayoutParams(params);
////        setContentView(customView);
//    }
//
//    public ActivityResultLauncher<Intent> getAutoCompleteLauncher() {
//        return autoCompleteLauncher;
//    }
//}
