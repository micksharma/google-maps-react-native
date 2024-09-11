package com.map;


import android.app.Application;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.map.MapMarker;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Import your custom package
import com.map.MyPackage;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
    new ReactNativeHost(this) {
      @Override
      public boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
      }

      @Override
      protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
          new MyPackage()// Add your custom package here
          // Add other packages manually here if needed
        );
      }
//     @Override
//     protected List<ReactPackage> getPackages() {
//     List<ReactPackage> packages = new PackageList(this).getPackages();
//      // Packages that cannot be autolinked yet can be added manually here, for example:
//      // packages.add(new MyReactNativePackage());
//       packages.add(new MyPackage());
//       return packages;
// }


      @Override
      protected String getJSMainModuleName() {
        return "index";
      }
    };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
