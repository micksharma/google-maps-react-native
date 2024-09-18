//// replace with your package
//package com.map;
//
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.Button;
//import android.widget.RelativeLayout;
//import android.location.Location;
//import android.content.pm.PackageManager;
//import android.Manifest;
//import android.content.Context;
//import android.graphics.Color;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.facebook.react.uimanager.SimpleViewManager;
//import com.facebook.react.uimanager.ThemedReactContext;
//import com.facebook.react.uimanager.annotations.ReactProp;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import androidx.core.app.ActivityCompat;
//import com.google.android.gms.tasks.OnSuccessListener;
////public class CustomView extends FrameLayout {
////  public CustomView(@NonNull Context context) {
////    super(context);
////    // set padding and background color
////    this.setPadding(16,16,16,16);
////    this.setBackgroundColor(Color.parseColor("#ffffff"));
////
////    // add default text view
////    TextView text = new TextView(context);
////    text.setText("Hi Everyone");
////    this.addView(text);
////  }
////}
//
////public class CustomView extends SimpleViewManager<MapView>{
////  public static final String REACT_CLASS = "CustomView";
////
////  @Override
////  public String getName(){
////    return REACT_CLASS;
////  }
////
////  @Override
////  protected MapView createViewInstance(ThemedReactContext reactContext){
////    MapView mapView = new MapView(reactContext);
////    mapView.onCreate(null);
////    mapView.onResume();
////    return mapView;
////  }
////
////  @ReactProp(name = "mapType")
////  public void setMapType(MapView view,String mapType){
////    GoogleMap map = view.getMap();
////    if(mapType.equals("satellite")){
////      map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
////    } else {
////      map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
////    }
////  }
////}
//
//
//public class CustomView extends FrameLayout implements OnMapReadyCallback {
//
//  private MapView mapView;
//  private GoogleMap googleMap;
//  private FusedLocationProviderClient fusedLocationClient;
//  private Button currentLocationButton;
//   private Activity activity;
//
//
//public CustomView(@NonNull Activity activity) {
//        super(activity);
//        this.activity = activity;
//        init(activity);
//    }
//
//    // Constructor with Activity and AttributeSet
//    public CustomView(@NonNull Activity activity, @Nullable AttributeSet attrs) {
//        super(activity, attrs);
//        this.activity = activity;
//        init(activity);
//    }
//
//
//public CustomView(@NonNull Context context) {
//   super(context);
//   if (context instanceof Activity) {
//            this.activity = (Activity) context;
//        }
//   init(context);
// }
//
//
// public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
//   super(context, attrs);
//    if (context instanceof Activity) {
//            this.activity = (Activity) context;
//        }
//   init(context);
// }
//
//
//
//  private void init(Context context) {
//    // this.setPadding(16, 16, 16, 16);
//    // this.setBackgroundColor(Color.parseColor("#5FD3F3"));
//
//    // Initialize MapView
//    mapView = new MapView(context);
//    mapView.onCreate(null); // This can be modified to handle saved instance state if needed
//    mapView.getMapAsync(this);
//
//    // Set up layout parameters for MapView
//    LayoutParams params = new LayoutParams(
//      ViewGroup.LayoutParams.MATCH_PARENT,
//      ViewGroup.LayoutParams.MATCH_PARENT
//    );
//    mapView.setLayoutParams(params);
//
//    // Add MapView to CustomView
//    this.addView(mapView);
//
//
//    currentLocationButton = new Button(context);
//    currentLocationButton.setText("Current Location");
//
//
//     RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
//       RelativeLayout.LayoutParams.WRAP_CONTENT,
//       RelativeLayout.LayoutParams.WRAP_CONTENT
//     );
//
//      buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//      buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//      currentLocationButton.setLayoutParams(buttonParams);
//
//       this.addView(currentLocationButton);
//
//     currentLocationButton.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v){
//        getCurrentLocation();
//      }
//     });
//    // Add default TextView
//    // TextView text = new TextView(context);
//    // text.setText("Hi Everyone");
//    // this.addView(text);
//  }
//
//  @Override
//  public void onMapReady(@NonNull GoogleMap googleMap) {
//    this.googleMap = googleMap;
//
//    // You can now interact with the GoogleMap instance
//     this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//    @Override
//      public void onMapClick(LatLng latLng){
//
//      Log.d("CustomView", "Lat: " + latLng.latitude + ", Lng: " + latLng.longitude);
//         googleMap.clear();
//
//         googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//    }
//    });
//  }
//
//
//  private void getCurrentLocation() {
//      Log.d("CustomView", " Location -> Lat: ");
//    // Log.d("CustomView", "Lat: " + latLng.latitude + ", Lng: " + latLng.longitude);
//    // Check for location permissions
//     if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//       ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//      //  ActivityCompat.requestPermissions(activity,
//      //               new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
//
//        // if (activity == null && getContext() instanceof Activity) {
//        //     activity = (Activity) getContext();
//        // }
//
//        if(activity != null){
//          ActivityCompat.requestPermissions(
//                activity,
//                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//                1
//        );
//        } else {
//            Log.e("CustomView", "Activity is null, cannot request permissions");
//        }
//
//       Log.d("CustomView2","Location -> Lat:");
//       return;
//     }
//
//       fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//        @Override
//        public void onSuccess(Location location) {
//            // If the location is not null, move the map camera to the current location
//            if (location != null) {
//                LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
//
//                // Log the current location coordinates
//                Log.d("CustomView", "Current Location -> Lat: " + currentLatLng.latitude + ", Lng: " + currentLatLng.longitude);
//
//                // Move the map's camera to the current location and add a marker
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15));
//                googleMap.clear();
//                googleMap.addMarker(new MarkerOptions().position(currentLatLng).title("Current Location"));
//            } else {
//                // Handle case where location is null
//                Log.d("CustomView", "Location is null");
//            }
//        }
//    }).addOnFailureListener(e -> {
//        // Handle the failure to get the current location
//        Log.e("CustomView", "Failed to get location", e);
//    });
//  }
//
//  public void onResume() {
//        mapView.onResume();
//    }
//
//    public void onPause() {
//        mapView.onPause();
//    }
//
//    public void onDestroy() {
//        mapView.onDestroy();
//    }
//
//    public void onLowMemory() {
//        mapView.onLowMemory();
//    }
//
//
//
//  // Lifecycle methods
////  @Override
////  protected void onResume() {
////    super.onResume();
////    mapView.onResume();
////  }
////
////  @Override
////  protected void onPause() {
////    super.onPause();
////    mapView.onPause();
////  }
////
////  @Override
////  protected void onDestroy() {
////    super.onDestroy();
////    mapView.onDestroy();
////  }
////
////  @Override
////  public void onLowMemory() {
////    super.onLowMemory();
////    mapView.onLowMemory();
////  }
//}





package com.map;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.location.Location;
import android.location.LocationManager;
import android.content.pm.PackageManager;
import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import android.location.Geocoder;
import android.location.Address;
import java.io.IOException;
import java.io.InputStream;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.gms.maps.model.Marker;
import android.util.DisplayMetrics;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;

import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import android.os.AsyncTask;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.Polyline;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.HashMap;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import android.widget.AdapterView;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class CustomView extends FrameLayout implements OnMapReadyCallback {

  private static final long DEBOUNCE_DELAY = 300;
  private Handler debounceHandler = new Handler(Looper.getMainLooper());
  private ViewFlipper viewFlipper;
  private Runnable debounceRunnable;
  private MapView mapView;
  private GoogleMap googleMap;
  private FusedLocationProviderClient fusedLocationClient;
  private Button currentLocationButton;
  private Button searchButton;
  private LatLng currentLatLng;
  private Activity activity;
  private EditText searchTextInput;
  private LatLng searchLatLng;
  private Marker destinationMarker;
  private TextView distanceTextView;
  private Polyline polyline;
  private ImageView searchIcon;
  private RelativeLayout page1;
  private RelativeLayout page2;
  private List<String> suggestions;
  private RequestQueue requestQueue;
  private ArrayAdapter<String> suggestionAdapter;
  private ListView suggestionListView;
//  private ActivityResultLauncher<Intent> autoCompleteLauncher;

//   public CustomView(@NonNull Activity activity, ActivityResultLauncher<Intent> autoCompleteLauncher) {
//        super(activity);
//        this.activity = activity;
//        this.autoCompleteLauncher = autoCompleteLauncher;
//        init(activity);
//    }


  // Constructor that requires an Activity
  public CustomView(@NonNull Activity activity) {
    super(activity);
    this.activity = activity;
    init(activity);
  }

  // Constructor that attempts to cast Context to Activity
  public CustomView(@NonNull Context context) {
    super(context);
    if (context instanceof Activity) {
      this.activity = (Activity) context;
    }
    init(context);
  }

  public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    if (context instanceof Activity) {
      this.activity = (Activity) context;
    }
    init(context);
  }

  // Initialization method
  private void init(Context context) {
   requestQueue = Volley.newRequestQueue(context);
   viewFlipper = new ViewFlipper(context);
   this.addView(viewFlipper);
  //  RequestQueue requestQueue = Volley.newRequestQueue(context);

    mapView = new MapView(context);
    mapView.onCreate(null);
    mapView.getMapAsync(this);

    LayoutParams params = new LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT,
      ViewGroup.LayoutParams.MATCH_PARENT
    );
    mapView.setLayoutParams(params);
    // this.addView(mapView);

    page1 = new RelativeLayout(context);

    RelativeLayout searchLayout = new RelativeLayout(context);
    currentLocationButton = new Button(context);
    currentLocationButton.setText("Current Location");

    GradientDrawable buttonBackground = new GradientDrawable();
    buttonBackground.setColor(Color.WHITE); // Set the background color
    buttonBackground.setStroke(2, Color.parseColor("#5698FB")); // Set the border color and width
    buttonBackground.setCornerRadius(12); // Set the border radius

    currentLocationButton.setBackground(buttonBackground);

    RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
      RelativeLayout.LayoutParams.WRAP_CONTENT,
      RelativeLayout.LayoutParams.WRAP_CONTENT
    );

    buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    buttonParams.setMargins(150, 200, 300, 600);
    currentLocationButton.setLayoutParams(buttonParams);

    // this.addView(currentLocationButton);
    // suggestionListView = new ListView(context);
    // suggestionListView.setVisibility(View.GONE);

//   Add Search TextInput
    suggestionListView = new ListView(context);
    suggestionListView.setVisibility(View.GONE);
    RelativeLayout.LayoutParams suggestionListParams = new RelativeLayout.LayoutParams(
    RelativeLayout.LayoutParams.MATCH_PARENT,
    RelativeLayout.LayoutParams.WRAP_CONTENT
);

   suggestionListParams.setMargins(0,120, 0, 0);
   suggestionListView.setLayoutParams(suggestionListParams);

    List<String> suggestions = new ArrayList<>();
    suggestionAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, suggestions);
    suggestionListView.setAdapter(suggestionAdapter);

    searchTextInput = new EditText(context);
    // searchTextInput.setCornerRadius(12);
   searchTextInput.setHint("Search");
//    searchTextInput.setMargins(50,16,16,0);
   GradientDrawable drawable = new GradientDrawable();
   drawable.setShape(GradientDrawable.RECTANGLE);
   drawable.setColor(Color.WHITE); // Set background color

   drawable.setCornerRadius(12);   // Set corner radius

// Apply the drawable as the background of the EditText
   searchTextInput.setBackground(drawable);

    suggestionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedLocation = suggestions.get(position);
        // Update the distanceTextView with the selected location
        distanceTextView.setText("Distance: " + selectedLocation);
        // Navigate back to page1
        page2.removeView(searchTextInput);
        page2.removeView(searchButton);
        page2.removeView(suggestionListView);
        page1.addView(searchTextInput);
        page1.addView(searchButton);
        viewFlipper.showPrevious(); // Navigate back to Page 1
    }
});
     searchTextInput.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            String query = s.toString();
            if (!query.isEmpty()) {
                fetchSuggestionsFromGoogle(query);
            }
        }
    });


    RelativeLayout.LayoutParams searchParams = new RelativeLayout.LayoutParams(
      800,
      110
    );

    searchParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
    searchParams.setMargins(120,30,16,0);

    searchTextInput.setLayoutParams(searchParams);



    // Add Search Button

    searchButton = new Button(context);

    GradientDrawable borderDrawable = new GradientDrawable();
    borderDrawable.setShape(GradientDrawable.RECTANGLE);
    borderDrawable.setColor(Color.WHITE);
    borderDrawable.setStroke(2, Color.parseColor("#5698FB"));

    searchButton.setBackground(borderDrawable);

    Drawable searchIcon = ContextCompat.getDrawable(context ,R.drawable.search_icon);
    int width = 48;
    int height =  48;
    searchIcon.setBounds(0,0,width , height);


//    searchButton.setCompoundDrawablesWithIntrinsicBounds(searchIcon, null, null, null);
    searchButton.setCompoundDrawables(searchIcon, null, null, null);
    searchButton.setCompoundDrawablePadding(8);
    searchButton.setBackgroundColor(Color.WHITE);
    RelativeLayout.LayoutParams searchButtonParams = new RelativeLayout.LayoutParams(
     100,
     110
    );

    searchButtonParams.addRule(RelativeLayout.BELOW,searchTextInput.getId());
    searchButtonParams.setMargins(30,30,16,0);
    searchButton.setLayoutParams(searchButtonParams);

    distanceTextView = new TextView(context);
    distanceTextView.setText("Location: ");
   
    distanceTextView.setTextSize(16); // Set text size if needed
    distanceTextView.setTextColor(Color.BLACK); // Set text color if needed
    distanceTextView.setBackgroundColor(Color.WHITE); // Set background color to white


    // Get the height of the screen
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int screenHeight = displayMetrics.heightPixels;

    // Set LayoutParams to occupy 1/4 of the screen height
    RelativeLayout.LayoutParams distanceTextParams = new RelativeLayout.LayoutParams(
      RelativeLayout.LayoutParams.MATCH_PARENT,
      screenHeight / 5
    );
    distanceTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    distanceTextParams.setMargins(0, 1200,0, 0); // Optional: Adjust margins if needed
    distanceTextView.setLayoutParams(distanceTextParams);

    // changeButton.setTextColor(Color.parseColor("#5698FB"));

    // Button changeButton = new Button(context);
    // changeButton.setText("Change");    
    // changeButton.setTextColor(Color.parseColor("#5698FB"));

    // GradientDrawable changeDrawable = new GradientDrawable();
    // // changeDrawable.setShape(GradienDrawable.RECTANGLE);
    // changeDrawable.setShape(GradientDrawable.RECTANGLE);
    // changeDrawable.setColor(Color.WHITE);
    // changeDrawable.setStroke(1 , Color.WHITE);

    // changeButton.setBackground(changeDrawable);

    // RelativeLayout.LayoutParams changeButtonParams = new RelativeLayout.LayoutParams(
    //         RelativeLayout.LayoutParams.WRAP_CONTENT ,
    //         RelativeLayout.LayoutParams.WRAP_CONTENT
    // );
    // int changeMarginLeft = 700; // Set left margin
    // int changeMarginTop = 1810;  // Set top margin
    // int changeMarginRight = 70; // Set right margin
    // int changeMarginBottom = 300; // Set bottom margin
    // changeButtonParams.setMargins(changeMarginLeft, changeMarginTop, changeMarginRight, changeMarginBottom);
        
    // changeButton.setLayoutParams(changeButtonParams);

    TextView clickableTextView = new TextView(context);
    clickableTextView.setText("Change");
    clickableTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    clickableTextView.setTextColor(Color.parseColor("#5698FB"));

    clickableTextView.setClickable(true);
    clickableTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                // Toast.makeText(context, "Text clicked!", Toast.LENGTH_SHORT).show();
                page1.removeView(searchTextInput);
            page1.removeView(searchButton);
            page2.addView(searchTextInput);
            page2.addView(searchButton);
            suggestionListView.setVisibility(View.VISIBLE); // Show suggestions
            page2.addView(suggestionListView);
            // viewFlipper.showNext();// Na
            navigateToPage2();
            }
        });

      TextPaint textPaint = clickableTextView.getPaint();
      textPaint.setUnderlineText(true); // Set unde

      RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        // textParams.addRule(RelativeLayout.CENTER_IN_PARENT); // Center the text in the parent layout
        textParams.setMargins(800 , 1850 , 100 ,200);
        clickableTextView.setLayoutParams(textParams);  
 
     

    Button confirmButton = new Button(context);
    confirmButton.setText("Confirm the Store Location");
    confirmButton.setTextColor(Color.WHITE);

   
    GradientDrawable buttonDrawable = new GradientDrawable();
    buttonDrawable.setShape(GradientDrawable.RECTANGLE);
    buttonDrawable.setColor(Color.parseColor("#5698FB"));
    buttonDrawable.setStroke(2, Color.parseColor("#5698FB"));

    float cornerRadius = 16f;
    buttonDrawable.setCornerRadius(cornerRadius);
    
    //  confirmButton.setBackground(Color.parseColor("#5698FB"));
    
 
     confirmButton.setBackground(buttonDrawable);
      RelativeLayout.LayoutParams confirmButtonParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT ,
            RelativeLayout.LayoutParams.WRAP_CONTENT
          );
        int marginLeft = 250; // Set left margin
        int marginTop = 2000;  // Set top margin
        int marginRight = 100; // Set right margin
        int marginBottom = 1; // Set bottom margin
        confirmButtonParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        
        confirmButton.setLayoutParams(confirmButtonParams);
  
   
    // this.addView(distanceTextView);
        page1.addView(mapView);
        page1.addView(currentLocationButton);
        page1.addView(searchTextInput);
        page1.addView(searchButton);
        page1.addView(distanceTextView);
        // page1.addView(changeButton);
        page1.addView(clickableTextView);
        page1.addView(confirmButton);
        

     page2 = new RelativeLayout(context);
        TextView page2Text = new TextView(context);
        page2Text.setText("This is Page 2");
        //  page2.addView(searchTextInput);
        // page2.addView(searchButton);
        page2Text.setTextSize(20);
        page2Text.setTextColor(Color.BLACK);
        page2Text.setPadding(100, 100, 100, 100);

        Button backButton = new Button(context);
        backButton.setText("Go Back");
        RelativeLayout.LayoutParams backButtonParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        backButtonParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        backButton.setLayoutParams(backButtonParams);

        // Handle back button click
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                page2.removeView(searchTextInput);
                page2.removeView(searchButton);
                page2.removeView(suggestionListView);
                page1.addView(searchTextInput);
                page1.addView(searchButton);
                // page2.addView(suggestionListView);
                viewFlipper.showPrevious();  // Navigate back to Page 1
            }
        });
        // page2.addView(searchTextInput);
        // page2.addView(searchButton);
        // page2.addView(page2Text);
        // page2.addView(searchTextInput);
        // page2.addView(searchButton);
        //  page2.addView(backButton);
          




        viewFlipper.addView(page1);
        viewFlipper.addView(page2);



    //
    searchButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v){
        getCurrentLocation();
        //  String locationName = searchTextInput.getText().toString();
        // searchLocation(locationName);
         new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String locationName = searchTextInput.getText().toString();
                if (currentLatLng != null) {
                    searchLocation(locationName);
                } else {
                    Log.e("CustomView", "Current location not available yet");
                }
            }
        }, 1000);
      }
    });
    currentLocationButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getCurrentLocation();
      }
    });

    searchTextInput.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // page1.removeView(searchTextInput);
        // page1.removeView(searchButton);
        // page2.addView(searchTextInput);
        // page2.addView(searchButton);
        // page2.addView(suggestionListView);
        //  navigateToPage2();
          page1.removeView(searchTextInput);
            page1.removeView(searchButton);
            page2.addView(searchTextInput);
            page2.addView(searchButton);
            suggestionListView.setVisibility(View.VISIBLE); // Show suggestions
            page2.addView(suggestionListView);
            // viewFlipper.showNext();// Na
            navigateToPage2();
      }
    });

  }

  private void searchLocation(String locationName) {

    Geocoder geocoder = new Geocoder(getContext());

    try {
      List<Address> addresses = geocoder.getFromLocationName(locationName, 1);
      if (addresses != null && addresses.size() > 0) {
        Address address = addresses.get(0);
        searchLatLng = new LatLng(address.getLatitude(), address.getLongitude());

        if (destinationMarker != null) {
          destinationMarker.remove();
        }

        // Add destination marker and animate camera
        destinationMarker = googleMap.addMarker(new MarkerOptions()
          .position(searchLatLng)
          .title(locationName));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(searchLatLng, 12));

        // Calculate and display the distance
         Log.d("CustomView11","Location is filled");
        // String directionsUrl = getDirectionsUrl(currentLatLng, searchLatLng);
        if (currentLatLng != null) {
            Log.d("CustomView1222","Location is filled");
          float[] distanceResult = new float[1];
          Location.distanceBetween(currentLatLng.latitude, currentLatLng.longitude,
            searchLatLng.latitude, searchLatLng.longitude, distanceResult);
          float distanceInKm = distanceResult[0] / 1000; // Convert to kilometers
          distanceTextView.setText("Location:" + distanceInKm);
           Log.d("CustomView1234","Location is filled");
            Log.d("CustomView1234", "Distance calculated: " + distanceInKm + " km");
          String directionsUrl = getDirectionsUrl(currentLatLng, searchLatLng);
          new FetchDirectionsTask().execute(directionsUrl);
           Log.d("CustomView1245","Location is filled");
        }
      } else {
        Log.e("CustomView", "Location not found");
      }
    } catch (IOException e) {
      Log.e("CustomView","Geocoder failed", e);
    }
  }

//   private void fetchSuggestionsFromGoogle(String query) {
//     String apiKey = "AIzaSyCNYG1npDP5g-IsgOg_TvQjRl7dBHllVTA";
//     String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + query +
//                  "&key=" + apiKey;

//     JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//         (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//             @Override
//             public void onResponse(JSONObject response) {
//                 try {
//                     JSONArray predictions = response.getJSONArray("predictions");
//                     List<String> suggestions = new ArrayList<>();

//                     for (int i = 0; i < predictions.length(); i++) {
//                         JSONObject prediction = predictions.getJSONObject(i);
//                         String description = prediction.getString("description");
//                         suggestions.add(description);
//                     }

//                     // Update ListView with suggestions
//                     suggestionAdapter.clear();
//                     suggestionAdapter.addAll(suggestions);
//                     suggestionAdapter.notifyDataSetChanged();

//                     // Show suggestions on Page 2
//                     if (viewFlipper.getDisplayedChild() != 1) {
//                         viewFlipper.showNext(); // Navigate to Page 2
//                     }
//                     page1.addView(suggestionListView);
//                     suggestionListView.setVisibility(View.VISIBLE);

//                 } catch (JSONException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, new Response.ErrorListener() {
//             @Override
//             public void onErrorResponse(VolleyError error) {
//                 error.printStackTrace();
//             }
//         });
//     // Add the request to the RequestQueue.
//     requestQueue.add(jsonObjectRequest);
// }

private void fetchSuggestionsFromGoogle(String query) {

    String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + query + "&key=AIzaSyCssBlgbisMPbKCohNoIIgycQFpJKe0_oM";
    Log.d("CustomViewFetch","fetch" + url);
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        response -> {
            try {
              Log.d("CustomViewFetch2","fetch"+ response);
                JSONArray predictions = response.getJSONArray("predictions");
                List<String> newSuggestions = new ArrayList<>();

                for (int i = 0; i < predictions.length(); i++) {
                    Log.d("CustomViewFetch5","fetch");
                    JSONObject prediction = predictions.getJSONObject(i);
                    newSuggestions.add(prediction.getString("description"));
                    Log.d("CustomViewFetch4","fetch");
                }
                suggestionAdapter.clear();
                suggestionAdapter.addAll(newSuggestions);
                suggestionAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        },
        error -> Log.e("CustomView", "Error fetching suggestions", error)
    );

    requestQueue.add(request);
}


  private String getDirectionsUrl(LatLng origin, LatLng destination) {
    String strOrigin = "origin=" + origin.latitude + "," + origin.longitude;
    String strDest = "destination=" + destination.latitude + "," + destination.longitude;
    String mode = "mode=driving";
    String parameters = strOrigin + "&" + strDest + "&" + mode;
    String output = "json";
    String apiKey = "AIzaSyCNYG1npDP5g-IsgOg_TvQjRl7dBHllVTA";  // Replace with your actual API key

    String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + apiKey;
    return url;
  }

  private class FetchDirectionsTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... url) {
      String data = "";
      try {
        data = downloadUrl(url[0]);
      } catch (Exception e) {
        Log.e("FetchDirectionsTask", "Background task failed", e);
      }
      return data;
    }

    @Override
    protected void onPostExecute(String result) {
      new ParseDirectionsTask().execute(result);
    }
  }


  private String downloadUrl(String strUrl) throws Exception {
    String data = "";
    InputStream inputStream = null;
    HttpURLConnection urlConnection = null;
    try {
      URL url = new URL(strUrl);
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.connect();

      inputStream = urlConnection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
      StringBuffer sb = new StringBuffer();
      String line = "";
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }

      data = sb.toString();
      br.close();
    } finally {
      inputStream.close();
      urlConnection.disconnect();
    }
    return data;
  }

  private class ParseDirectionsTask extends AsyncTask<String, Void, List<List<HashMap<String, String>>>> {
    @Override
    protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
      JSONObject jsonObject;
      List<List<HashMap<String, String>>> routes = null;

      try {
        jsonObject = new JSONObject(jsonData[0]);
        DirectionsJSONParser parser = new DirectionsJSONParser();
        routes = parser.parse(jsonObject);
      } catch (Exception e) {
        Log.e("ParseDirectionsTask","JSON parsing failed",e);
      }
      return routes;
    }

    protected void onPostExecute(List<List<HashMap<String, String>>> result) {
      ArrayList<LatLng> points;
      PolylineOptions polylineOptions = null;

      // Drawing the polyline in the Google Map
      if (result != null) {
        for (int i = 0; i < result.size(); i++) {
          points = new ArrayList<>();
          polylineOptions = new PolylineOptions();

          // Fetching all the points in the i-th route
          List<HashMap<String, String>> path = result.get(i);
          for (int j = 0; j < path.size(); j++) {
            HashMap<String, String> point = path.get(j);

            double lat = Double.parseDouble(point.get("lat"));
            double lng = Double.parseDouble(point.get("lng"));
            LatLng position = new LatLng(lat, lng);

            points.add(position);
          }
          polylineOptions.addAll(points);
          polylineOptions.width(12);
          polylineOptions.color(Color.BLUE);
          polylineOptions.geodesic(true);
        }

        // Remove the previous polyline if it exists
        if (polyline != null) {
          polyline.remove();
        }

        // Adding the polyline to the map
        if (polylineOptions != null) {
          polyline = googleMap.addPolyline(polylineOptions);
        }
      }
    }
  }

  private class DirectionsJSONParser {
    // Receives a JSONObject and returns a list of lists containing latitude and longitude
    public List<List<HashMap<String, String>>> parse(JSONObject jObject) {
      List<List<HashMap<String, String>>> routes = new ArrayList<>();
      JSONArray jRoutes;
      JSONArray jLegs;
      JSONArray jSteps;

      try {
        jRoutes = jObject.getJSONArray("routes");

        // Looping through all routes
        for (int i = 0; i < jRoutes.length(); i++) {
          jLegs = ((JSONObject) jRoutes.get(i)).getJSONArray("legs");
          List path = new ArrayList<>();

          // Looping through all legs
          for (int j = 0; j < jLegs.length(); j++) {
            jSteps = ((JSONObject) jLegs.get(j)).getJSONArray("steps");

            // Looping through all steps
            for (int k = 0; k < jSteps.length(); k++) {
              String polyline = "";
              polyline = (String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points");
              List<LatLng> list = decodePolyline(polyline);

              // Looping through all points
              for (int l = 0; l < list.size(); l++) {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("lat", Double.toString(((LatLng) list.get(l)).latitude));
                hm.put("lng", Double.toString(((LatLng) list.get(l)).longitude));
                path.add(hm);
              }
            }
            routes.add(path);
          }
        }

      } catch (Exception e) {
        Log.e("DirectionsJSONParser", "Parsing error", e);
      }
      return routes;
    }

    // Method to decode polyline points
    private List<LatLng> decodePolyline(String encoded) {
      List<LatLng> poly = new ArrayList<>();
      int index = 0, len = encoded.length();
      int lat = 0, lng = 0;

      while (index < len) {
        int b, shift = 0, result = 0;
        do {
          b = encoded.charAt(index++) - 63;
          result |= (b & 0x1f) << shift;
          shift += 5;
        } while (b >= 0x20);
        int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
        lat += dlat;

        shift = 0;
        result = 0;
        do {
          b = encoded.charAt(index++) - 63;
          result |= (b & 0x1f) << shift;
          shift += 5;
        } while (b >= 0x20);
        int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
        lng += dlng;

        LatLng p = new LatLng((((double) lat / 1E5)),
          (((double) lng / 1E5)));
        poly.add(p);
      }
      return poly;
    }
  }

   private void navigateToPage2() {
        viewFlipper.showNext();
   }

  @Override
  public void onMapReady(@NonNull GoogleMap googleMap) {
    this.googleMap = googleMap;

    this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
      @Override
      public void onMapClick(LatLng latLng) {
        currentLatLng = new LatLng(latLng.latitude, latLng.longitude);
        Log.d("CustomView", "Lat: " + latLng.latitude + ", Lng: " + latLng.longitude);
        googleMap.clear();
        googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
        // navigateToPage2();
      }
    });
  }

  private void getCurrentLocation() {
    Log.d("CustomView", "Requesting location...");

    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
      ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      // Ensure activity is not null before requesting permissions
      if (activity != null) {
        ActivityCompat.requestPermissions(
          activity,
          new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
          1
        );
      } else {
        Log.e("CustomView", "Activity is null, cannot request permissions");
      }
      return;
    }

    if (fusedLocationClient == null) {
      fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
    }

    fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
      @Override
      public void onSuccess(Location location) {
        if (location != null) {
          currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
          Log.d("CustomView10", "Current Location -> Lat: " + currentLatLng.latitude + ", Lng: " + currentLatLng.longitude);
          googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15));
          googleMap.clear();
          googleMap.addMarker(new MarkerOptions().position(currentLatLng).title("Current Location"));
        } else {
          Log.d("CustomView11","Location is null");
        }
      }
    }).addOnFailureListener(e -> {
      Log.e("CustomView", "Failed to get location", e);
    });
  }

//   private void searchLocation() {
//        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG);
//
//        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
//                .build(getContext());
//
//        // autoCompleteLauncher.launch(intent);
//         if (autoCompleteLauncher != null) {
//            autoCompleteLauncher.launch(intent);
//        } else {
//            Log.e("CustomView", "AutoComplete Launcher is null");
//        }
//    }

  public void onResume() {
    mapView.onResume();
  }

  public void onPause() {
    mapView.onPause();
  }

  public void onDestroy() {
    mapView.onDestroy();
  }

  public void onLowMemory() {
    mapView.onLowMemory();
  }
}


//package com.map;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.RelativeLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//
//import com.facebook.react.uimanager.SimpleViewManager;
//import com.facebook.react.uimanager.ThemedReactContext;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.tasks.OnSuccessListener;
//
//public class CustomView extends FrameLayout implements OnMapReadyCallback {
//
//  private MapView mapView;
//  private GoogleMap googleMap;
//  private FusedLocationProviderClient fusedLocationClient;
//  private Button currentLocationButton;
//  private Activity activity;
//
//  // Constructor that requires an Activity
//  public CustomView(@NonNull Activity activity) {
//    super(activity);
//    this.activity = activity;
//    init(activity);
//  }
//
//  // Constructor that attempts to cast Context to Activity
//  public CustomView(@NonNull Context context) {
//    super(context);
//    if (context instanceof Activity) {
//      this.activity = (Activity) context;
//    }
//    init(context);
//  }
//
//  public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
//    super(context, attrs);
//    if (context instanceof Activity) {
//      this.activity = (Activity) context;
//    }
//    init(context);
//  }
//
//  // Initialization method
//  private void init(Context context) {
//    mapView = new MapView(context);
//    mapView.onCreate(null);
//    mapView.getMapAsync(this);
//
//    LayoutParams params = new LayoutParams(
//      ViewGroup.LayoutParams.MATCH_PARENT,
//      ViewGroup.LayoutParams.MATCH_PARENT
//    );
//    mapView.setLayoutParams(params);
//    this.addView(mapView);
//
//    currentLocationButton = new Button(context);
//    currentLocationButton.setText("Current Location");
//
//    RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
//      RelativeLayout.LayoutParams.WRAP_CONTENT,
//      RelativeLayout.LayoutParams.WRAP_CONTENT
//    );
//    buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//    buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//    currentLocationButton.setLayoutParams(buttonParams);
//
//    this.addView(currentLocationButton);
//
//    currentLocationButton.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        getCurrentLocation();
//      }
//    });
//
//    fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
//  }
//
//  @Override
//  public void onMapReady(@NonNull GoogleMap googleMap) {
//    this.googleMap = googleMap;
//    this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//      @Override
//      public void onMapClick(LatLng latLng) {
//        Log.d("CustomView", "Lat: " + latLng.latitude + ", Lng: " + latLng.longitude);
//        if (googleMap != null) {
//          googleMap.clear();
//          googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//        }
//      }
//    });
//  }
//
//  private void getCurrentLocation() {
//    Log.d("CustomView", "Requesting location...");
//
//    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//      ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//      if (activity != null) {
//        ActivityCompat.requestPermissions(
//          activity,
//          new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//          1
//        );
//      } else {
//        Log.e("CustomView", "Activity is null, cannot request permissions");
//      }
//      return;
//    }
//
//    if (fusedLocationClient != null) {
//      fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//        @Override
//        public void onSuccess(Location location) {
//          if (location != null && googleMap != null) {
//            LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
//            Log.d("CustomView", "Current Location -> Lat: " + currentLatLng.latitude + ", Lng: " + currentLatLng.longitude);
//            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15));
//            googleMap.clear();
//            googleMap.addMarker(new MarkerOptions().position(currentLatLng).title("Current Location"));
//          } else {
//            Log.d("CustomView", "Location is null or GoogleMap is not ready");
//          }
//        }
//      }).addOnFailureListener(e -> {
//        Log.e("CustomView", "Failed to get location", e);
//      });
//    } else {
//      Log.e("CustomView", "FusedLocationClient is null");
//    }
//  }
//
//  public void onResume() {
//
//    mapView.onResume();
//  }
//
//  public void onPause() {
//
//    mapView.onPause();
//  }
//
//  public void onDestroy() {
//
//    mapView.onDestroy();
//  }
//
//  public void onLowMemory() {
//
//    mapView.onLowMemory();
//  }
//}


