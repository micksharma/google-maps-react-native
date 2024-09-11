// import { useState } from 'react';
// import { ViewStyle ,StyleSheet, View, Text , NativeModules , Button , requireNativeComponent} from 'react-native';
import { requireNativeComponent, type ViewStyle ,StyleSheet , View, type ViewProps} from 'react-native';

interface GoogleMapViewProps extends ViewProps {
  latitude?: number ,
  longitude?: number,
  zoom?:number ,
  style?:ViewStyle
}

interface MyCustomViewProps {
  style?: ViewStyle; // Allow passing style               // For android
}

const MyViewManager =
  requireNativeComponent<MyCustomViewProps>('MyViewManager');   // For android

// const MapView = requireNativeComponent<GoogleMapViewProps>('MapView'); // For IOS
// const App: React.FC<GoogleMapViewProps> = (props) => {  // For IOS
export default function App()  {
  //  const [result, setResult] = useState<number | undefined>();
  return (
    // <View style={styles.container}>
    //   <View>
    //   <Text>Result: 20</Text>
    //   </View>
    //   <Button
    //   title="Click to invoke your native module!"
    //   color="#841584"

    // />
    // <View>
    // For android 
    <MyViewManager style={{ flex: 1 }} />
    //  <MapView style={{flex:1 }} {...props}/>
    // </View>
   
  );
}



const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
