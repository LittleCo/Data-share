package com.hut.utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Json<type> {

   private JSONObject JsonObj = null;
   
   public String mapToJson(Map param){
	 	   
	   JsonObj = new JSONObject((Map)param); 
	   
	   return JsonObj.toString();
   }
   private void initJson(){
	   if(JsonObj == null)
	   mapToJson(null);
   }
   public String addElements(String key, Object value){
	   initJson();
	   JsonObj.put(key, value);
	   return JsonObj.toString();
   }
	@Override
	public String toString() {
		return JsonObj.toString();
	}
   
}
