package com.kmit.Gmail_skill;

import java.util.*;
class Test{
	public static void main(String []aths){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int n=sc.nextInt();
		String aa="";
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			char ch;
			if(c==' ') {
				aa=aa+' ';
			}
			else {
				ch=(char)(((int)(c+n)-97)%26+97);
				aa+=ch;
			}

		}
		String aaa="";
		for(int i=0;i<s.length();i++){
			char c=aa.charAt(i);
			char ch;
			if(c==' ') {
				aaa=aaa+' ';
			}
			else {
				ch=(char)(((int)(c-n)-97)%26+97);
				aaa+=ch;
			}

		}
		System.out.println(aa);
		System.out.println(aaa);
	}
}