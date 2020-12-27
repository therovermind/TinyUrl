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
	
	public static int getId(String shortURL) {
		int id=0;
		for (int i = 0; i < shortURL.length(); i++)  
        {  
            if ('a' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'z')  
            id = id * 62 + shortURL.charAt(i) - 'a';  
            if ('A' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'Z')  
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;  
            if ('0' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= '9')  
            id = id * 62 + shortURL.charAt(i) - '0' + 52;  
        }  
        return id;  
    }  
	
}
