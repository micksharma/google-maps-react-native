//// replace with your package
//package com.map;
//
//import android.view.Choreographer;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.FragmentActivity;
//
//import com.facebook.react.bridge.ReactApplicationContext;
//import com.facebook.react.bridge.ReadableArray;
//import com.facebook.react.common.MapBuilder;
//import com.facebook.react.uimanager.annotations.ReactProp;
//import com.facebook.react.uimanager.annotations.ReactPropGroup;
//import com.facebook.react.uimanager.ViewGroupManager;
//import com.facebook.react.uimanager.ThemedReactContext;
//
//import java.util.Map;
//
//public class MyViewManager extends ViewGroupManager<FrameLayout> {
//
//  public static final String REACT_CLASS = "MyViewManager";
//  public final int COMMAND_CREATE = 1;
//  private int propWidth;
//  private int propHeight;
//
//  ReactApplicationContext reactContext;
//
//  public MyViewManager(ReactApplicationContext reactContext) {
//    this.reactContext = reactContext;
//  }
//
//  @Override
//  public String getName() {
//    return REACT_CLASS;
//  }
//
//  /**
//   * Return a FrameLayout which will later hold the Fragment
//   */
//  @Override
//  public FrameLayout createViewInstance(ThemedReactContext reactContext) {
//    return new FrameLayout(reactContext);
//  }
//
//  /**
//   * Map the "create" command to an integer
//   */
//  @Nullable
//  @Override
//  public Map<String, Integer> getCommandsMap() {
//    return MapBuilder.of("create", COMMAND_CREATE);
//  }
//
//  /**
//   * Handle "create" command (called from JS) and call createFragment method
//   */
//  @Override
//  public void receiveCommand(
//    @NonNull FrameLayout root,
//    String commandId,
//    @Nullable ReadableArray args
//  ) {
//    super.receiveCommand(root, commandId, args);
//    int reactNativeViewId = args.getInt(0);
//    int commandIdInt = Integer.parseInt(commandId);
//
//    switch (commandIdInt) {
//      case COMMAND_CREATE:
//        createFragment(root, reactNativeViewId);
//        break;
//      default: {}
//    }
//  }
//
//  @ReactPropGroup(names = {"width", "height"}, customType = "Style")
//  public void setStyle(FrameLayout view, int index, Integer value) {
//    if (index == 0) {
//      propWidth = value;
//    }
//
//    if (index == 1) {
//      propHeight = value;
//    }
//  }
//
//  /**
//   * Replace your React Native view with a custom fragment
//   */
//  public void createFragment(FrameLayout root, int reactNativeViewId) {
//    ViewGroup parentView = (ViewGroup) root.findViewById(reactNativeViewId);
//    setupLayout(parentView);
//
//    final MyFragment myFragment = new MyFragment();
//    FragmentActivity activity = (FragmentActivity) reactContext.getCurrentActivity();
//    activity.getSupportFragmentManager()
//      .beginTransaction()
//      .replace(reactNativeViewId, myFragment, String.valueOf(reactNativeViewId))
//      .commit();
//  }
//
//  public void setupLayout(View view) {
//    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
//      @Override
//      public void doFrame(long frameTimeNanos) {
//        manuallyLayoutChildren(view);
//        view.getViewTreeObserver().dispatchOnGlobalLayout();
//        Choreographer.getInstance().postFrameCallback(this);
//      }
//    });
//  }
//
//  /**
//   * Layout all children properly
//   */
//  public void manuallyLayoutChildren(View view) {
//    // propWidth and propHeight coming from react-native props
//    int width = propWidth;
//    int height = propHeight;
//
//    view.measure(
//      View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
//      View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
//
//    view.layout(0, 0, width, height);
//  }
//}
package com.map;

import android.view.View;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.MapView;
import android.app.Activity;

public class MyViewManager extends SimpleViewManager<View> {

  public static final String REACT_CLASS = "MyViewManager";

  @Override
  public String getName() {
    return REACT_CLASS;
  }

//  @Override
//  protected View createViewInstance(ThemedReactContext reactContext) {
//    CustomView customView = new CustomView(reactContext); // Ensure CustomView is your custom class
//    // Set up your CustomView here (e.g., set properties, layout, etc.)
//    return customView;
//  }
@Override
protected View createViewInstance(ThemedReactContext reactContext) {
  Activity activity = reactContext.getCurrentActivity(); // Get the current Activity from the context

  if (activity != null) {
    // Pass the activity to the CustomView constructor
     CustomView customView = new CustomView(activity);
    // return new CustomView(activity);
    // Set up your CustomView here (e.g., set properties, layout, etc.)
     return customView;
  } else {
    // Fallback to context if the activity is null (for some edge cases)
     CustomView customView = new CustomView(reactContext);
     return customView;
    // return new CustomView(reactContext);
  }
}

  // @ReactProp(name = "mapType")
  // public void setMapType(MapView view , String mapType){
  //   GoogleMap map = view.getMap();
  //   if (map != null) {
  //           if (mapType.equals("satellite")) {
  //               map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
  //           } else {
  //               map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
  //           }
  //       }
  // }




}
