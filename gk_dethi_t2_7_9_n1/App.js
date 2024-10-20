import { Text, SafeAreaView, StyleSheet } from 'react-native';

// You can import supported modules from npm

import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

// or any files within the Snack
import ScreenMain from './components/ScreenMain';
import Screen01 from './components/Screen_01';
import Screen02 from './components/Screen_02';

const Stack = createNativeStackNavigator();
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="ScreenMain">
       <Stack.Screen name="ScreenMain" component={ScreenMain} options = {{headerShown:false}}/> 
        
        <Stack.Screen name="Screen01" component={Screen01} options = {{headerShown:false}}/>
        <Stack.Screen name="Screen02" component={Screen02} options = {{headerShown:false}}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  
});
