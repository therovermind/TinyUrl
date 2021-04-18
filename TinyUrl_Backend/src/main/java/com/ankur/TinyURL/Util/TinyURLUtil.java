package com.ankur.TinyURL.Util;

public class TinyURLUtil {
	public static String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
	public static String getShortString(int n) {
		String shortendUrl="";
		while(n>0) {
			shortendUrl += map.toCharArray()[n%62];
			n=n/2;
		}
		return shortendUrl;
	}
	
	public static int getId(String shortString) {
		StringBuilder s = new StringBuilder(shortString).reverse();
		char lastChar = s.charAt(0);
		int id= map.indexOf(lastChar);
		for(int i=1; i<s.length();i++) {
			id = map.indexOf(s.charAt(i))>id*2%62 ? id*2 +1 : id*2;
		}
        return id;  
    }  
	
}
