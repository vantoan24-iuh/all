import { Text, View, StyleSheet, Image,SafeAreaView,TextInput, FlatList,TouchableOpacity } from 'react-native';
import React,{useEffect, useState,useCallback} from 'react';
import { useFocusEffect } from '@react-navigation/native';



const Task = ({taskId,jobName, navigation, onDelete,textName}) => (
   <View style={[styles.task, styles.elevation]}>

          {/* content job and icon tick */}
          <View style={{flexDirection:'row', alignItems:'center'}}>
            <TouchableOpacity style={{marginRight:10}}>
                <Image source={require('../assets/tickl.png')} style = {{resizeMode:'cover', width: 27, height: 27, }}/>
            </TouchableOpacity>

            <View>
              <Text style={styles.text}>{jobName}</Text>
            </View>
          </View>

          {/* Button execute */}
          <View style={{flexDirection:'row', alignItems:'center'}}>
            {/* EDIT */}
            <TouchableOpacity style={{marginRight:15}}
              onPress={() => navigation.navigate({
                name:'Screen02',
                params: {specify: 'EDIT', jobName: jobName, taskId: taskId, textName: textName},
              })}
            >
                <Image source={require('../assets/edit.png')} style = {{resizeMode:'cover', width: 27, height: 27, }}/>
            </TouchableOpacity>

            {/* Delete */}
            <TouchableOpacity 
              onPress={() => onDelete()}
            >
                <Image source={require('../assets/icons8-delete-27.png')} style = {{resizeMode:'cover', width: 27, height: 27, }}/>
            </TouchableOpacity>
          </View>
          
    </View>
);

export default function Screen01({navigation, route}) {

  const [data, setData] = useState(null);


  useFocusEffect(
      // Sử dụng useCallback để tránh việc render lại các hàm không cần thiết
      useCallback(() => {
        fetchApi(); // Gọi hàm fetchAPI khi màn hình được focus
      }, [])
  );


  const fetchApi = async () => {
    try{
      const respone = await fetch('https://67039ce3ab8a8f892730d9f4.mockapi.io/api/task');
      const json = await respone.json();
      setData(json);
    } catch(e) {
      console.log(e);
    }
  }

  const delteTask = async (id) => {
     try{
      await fetch(`https://67039ce3ab8a8f892730d9f4.mockapi.io/api/task/${id}`,
        {
          method:'DELETE',
        }       
      );
      fetchApi();
    } catch(e) {
      console.log(e);
    }
  }


  return (
    <SafeAreaView style={styles.container}>
      <View style={{display:'flex', justifyContent:'space-between', alignItems:'center', flexDirection:'row'}}>
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

      <View style={{display:'flex', flexDirection:'row', alignItems:'center', borderWidth:1, borderColor:'#BDC0C7', width:'100%', padding:10, borderRadius:4, marginVertical:40}}>
        <Image source={require('../assets/iconemail.png')} />
        <TextInput placeholder="Enter your name" style={{fontSize:18, color: '#C4C4C4', marginLeft:10}}/>
      </View>

      <FlatList
        data={data}
        renderItem={({item}) => (
          <Task
            key={item.id}
            taskId={item.id}
            jobName={item.content}
            textName={route.params?.textName}
            navigation={navigation}
            onDelete={()=> delteTask(item.id)}
          />
        )}
        keyExtractor={item => item.id}

      />
      
      <View style={{display:'flex', alignItems:'center', marginTop:30, marginBottom:50}}>
        <TouchableOpacity style ={{backgroundColor:'#25C3D9', width:'20%', borderRadius:50}}
          onPress={() => navigation.navigate({
            name:'Screen02',
            params: {textName:route.params?.textName, specify: 'ADD'}
          })}
        >
           <Text style ={{fontSize:45, color:'white', textAlign:'center'}}>+</Text>
        </TouchableOpacity>
      </View>


    
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    margin: 20,
  },
  task: {
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        backgroundColor: "rgba(222, 225, 230, 0.47)",
        padding: 15,
        borderRadius: 24,
        marginVertical: 10,
        width: '100%',
     },
     text: {
        fontSize: 16,
        fontWeight:'bold',
     },
     elevation: {
      elevation: 20,
      shadowColor: 'black',
    },
});
