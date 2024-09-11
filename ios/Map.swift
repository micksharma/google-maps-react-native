import UIKit

@objc(MapView)
class MapView: UIView {

  // @objc(multiply:withB:withResolver:withRejecter:)
  // func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
  //   resolve(a*b)
  // }
    // var mapView: GMSMapView!
//    override init(frame: CGRect) {
//         super.init(frame: frame)
//         setupMap()
//     }

//     required init?(coder aDecoder: NSCoder) {
//         super.init(coder: aDecoder)
//         setupMap()
//     }

//      private func setupMap() {
//         let camera = GMSCameraPosition.camera(withLatitude: -33.86, longitude: 151.20, zoom: 6.0)
//         mapView = GMSMapView.map(withFrame: self.bounds, camera: camera)
//         mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
//         self.addSubview(mapView) // Fixed typo from addSubView to addSubview
//     }

}


// import UIKit
// import GoogleMaps

// @objc class MapView: UIView {
//   var mapView: GMSMapView! 

//   override init(frame: CGRect) {
//     super.init(frame: frame)
//     setupMap()
//   }

//   required init?(coder aDecoder: NSCoder){
//     super.init(coder: aDecoder)
//     setupMap()
//   }

//   private func setupMap(){
//     let camera = GMSCameraPosition.camera(withLatitude: -33.86 , longitude:151.20 , zoom:6.0)
//     mapView = GMSMapView.map(withFrame: self.bounds, camera: camera)
//     mapView.autoresizingMask = [.flexibleWidth , .flexibleHeight]
//     self.addSubView(mapView)
//   }
// }

// @objc(MapViewManager)
// class MapViewManager: RCTViewManager {
//   override func view() -> UIView! {
//     return MapView()
//   }

//   override static func requiresMainQueueSetup -> Bool {
//     return true
//   }
// }

// import UIKit
// import GoogleMaps

// @objc(MapView) // This should match the name used in the registration in Objective-C++
// class MapView: UIView {
//     // var mapView: GMSMapView!

//     // override init(frame: CGRect) {
//     //     super.init(frame: frame)
//     //     setupMap()
//     // }

//     // required init?(coder aDecoder: NSCoder) {
//     //     super.init(coder: aDecoder)
//     //     setupMap()
//     // }

//     // private func setupMap() {
//     //     let camera = GMSCameraPosition.camera(withLatitude: -33.86, longitude: 151.20, zoom: 6.0)
//     //     mapView = GMSMapView.map(withFrame: self.bounds, camera: camera)
//     //     mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
//     //     self.addSubview(mapView) // Corrected method name to addSubview
//     // }
//   //   @objc(multiply:withB:withResolver:withRejecter:)
//   //   func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
//   //   resolve(a*b)
//   // }
// }

@objc(MapViewManager)
class MapViewManager: RCTViewManager {
    override func view() -> UIView! {
        return MapView()
    }

    override static func requiresMainQueueSetup() -> Bool {
        return true
    }
}

