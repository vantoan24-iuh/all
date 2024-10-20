import { Text, View, StyleSheet, Image,SafeAreaView,TextInput,TouchableOpacity } from 'react-native';
import React,{useState, useEffect} from 'react'

export default function Screen02({navigation, route}) {

  const [textContent, setJob] = useState({
    content: "",
  });

  useEffect(() => {
    if(route.params?.specify ==='EDIT' && route.params?.jobName) {
      setJob({content : route.params?.jobName})
    }
  },[route.params]);

  const urlApi = route.params?.specify ==='ADD'?'https://67039ce3ab8a8f892730d9f4.mockapi.io/api/task':`https://67039ce3ab8a8f892730d9f4.mockapi.io/api/task/${route.params?.taskId}`;

  const method = route.params?.specify ==='ADD'?'POST':'PUT'

  const handelApi = async (event) => {
    try {
      const respone = await fetch(urlApi,
        {
          method: method,
          headers: {
            "Content-Type" :"application/json",
          },
          body: JSON.stringify(textContent),
        }
      )
      const json = await respone.json();
      setTask({textJob:""})
    } catch(e) {
      console.log(e);
    }
  }



  return (
    <SafeAreaView style={styles.container}>
      <View style={{display:'flex', justifyContent:'space-between', alignItems:'center', flexDirection:'row-reverse'}}>
        <TouchableOpacity 
          onPress={() =>navigation.goBack()}>  
          <Image source={require('../assets/muiten.png')}/>
        </TouchableOpacity>
        
        
        <View style={{display:'flex', alignItems:'center',flexDirection:'row'}}>
          <Image source={require('../assets/userimage.png')}/>

          <View style={{flexDirection:'column', paddingLeft:5}}>
            <Text style={{fontSize:18, fontWeight:700, paddingLeft:10}}>{route.params?.textName}</Text>
            <Text style={{fontSize:14, fontWeight:400, color:'#AFB1B3'}}>Have agreate day head</Text>
          </View>
        </View>
      </View>

      <Text style={{ marginVertical:40,textAlign:'center', fontSize:32, fontWeight:'bold'}}> {route.params?.specify} YOUR JOB</Text>

      <View style={{display:'flex', flexDirection:'row', alignItems:'center', borderWidth:1, borderColor:'#BDC0C7', width:'100%', padding:10, borderRadius:4}}>
        <Image source={require('../assets/listicon.png')} />
        <TextInput placeholder="Enter your job" style={{fontSize:18, color: '#848688', marginLeft:10}} 
          value={textContent.content}
          onChangeText={(text) => setJob({ content: text })}
        />
      </View>

       <View style={{display:'flex', alignItems:'center', marginTop:45, marginBottom:50}}>
        <TouchableOpacity style ={{backgroundColor:'#25C3D9', width:'55%', borderRadius:10}}
          onPress={() => {
              handelApi();
              navigation.navigate({
                name:'Screen01',
                params: {textName:route.params?.textName}
              });
            }
          }
        >
           <Text style ={{fontSize:18, color:'white', textAlign:'center', paddingVertical:10}}>FINISH -></Text>
        </TouchableOpacity>
      </View>
      
      <View style={{display:'flex', alignItems:'center',marginVertical:40}}>
         <Image source={require('../assets/Image95.png')} />
      </View>


    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    margin: 20,
  },
});
