import { Text, View, StyleSheet, Image,SafeAreaView, TextInput,TouchableOpacity } from 'react-native';
import React,{useEffect, useState} from 'react';

export default function ScreenMain({navigation, route}) {
    const [textName, setTextName] = useState('');

  return (
    <SafeAreaView style={styles.container}>
      <Image source={require('../assets/Image95.png')} style={{marginVertical:40}}/>

      <Text style={{textAlign:'center', fontSize:24, color:'#8353E2', fontWeight:'bold'}}> MANAGE YOUR {'\n'} TASK</Text>

      <View style={{display:'flex', flexDirection:'row', alignItems:'center', borderWidth:1, borderColor:'#BDC0C7', width:'90%', padding:10, borderRadius:10, marginVertical:40}}>
        <Image source={require('../assets/iconemail.png')} />
        <TextInput placeholder="Enter your name" style={{fontSize:18, color: '#C4C4C4', marginLeft:10}} value={textName} onChangeText={setTextName}/>
      </View>
      
      <TouchableOpacity style={{backgroundColor: '#25C3D9', paddingHorizontal:35, paddingVertical:12, borderRadius:10,marginTop:40}}
        onPress={() => navigation.navigate({
          name: 'Screen01',
          params: {textName: textName}

        })}
      >
        <Text style={{color:'white', fontSize:16, textAlign:'center'}}> GET STARTED -> </Text>
      </TouchableOpacity>

    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    padding: 20,
  },
});
