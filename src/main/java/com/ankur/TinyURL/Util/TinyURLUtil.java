package com.ankur.TinyURL.Util;

public class TinyURLUtil {
    
	public static String getShortString(int n) {
		String shortendUrl="";
		char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		while(n>0) {
			shortendUrl += map[n%62];
			n=n/2;
		}
		return shortendUrl;
	}
	
	public static int getId(String shortString) {
		StringBuilder s = new StringBuilder(shortString).reverse();
		int id=s.charAt(0);
		for(int i=1; i<s.length();i++) {
			id = s.charAt(i)>id*2 ? id*2 +1 : id*2;
		}
        return id;  
    }  
	
}
