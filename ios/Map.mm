// #import <React/RCTBridgeModule.h>

// @interface RCT_EXTERN_MODULE(MapView, NSObject)

// RCT_EXTERN_METHOD(multiply:(float)a withB:(float)b
//                  withResolver:(RCTPromiseResolveBlock)resolve
//                  withRejecter:(RCTPromiseRejectBlock)reject)

// + (BOOL)requiresMainQueueSetup
// {
//   return NO;
// }

// @end

//  #import "React/RCTViewManager.h"


// @interface RCT_EXTERN_MODULE(MapViewManager , RCTViewManager)
// RCT_EXPORT_VIEW_PROPERTY()
// @end


 #import <React/RCTBridgeModule.h>
 #import <React/RCTViewManager.h>
 #import "Map-Bridging-Header.h"

@interface RCT_EXTERN_MODULE(MapViewManager,  RCTViewManager)
// Expose any props you need here with RCT_EXPORT_VIEW_PROPERTY if needed
@end


