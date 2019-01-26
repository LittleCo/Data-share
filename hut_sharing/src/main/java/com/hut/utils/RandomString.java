package com.hut.utils;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository("RandomString")
public class RandomString {

	private final String str = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String getRandomString(int len){
       int strL = str.length();
	   StringBuffer sb = new StringBuffer();
       for(int i =0; i<len; i++){
	       sb.append(str.charAt((int)(Math.random()*strL)));
       }
	   return sb.toString();
    }
    
}
