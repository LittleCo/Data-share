package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hut.utils.Json;

public class main {
   public static void main(String[] args){

	  
	  Map<String, Object> map = new HashMap();
	  map.put("father", "xpf2");
	  
	  ArrayList<String> arr = new ArrayList();
	  arr.add("a");
	  arr.add("b");
	
	  
	  Json<Map> json = new Json();
	  String str = json.mapToJson(map);
	  System.out.println(str);
	  System.out.println(json.addElements("arr", arr));
   }
}
