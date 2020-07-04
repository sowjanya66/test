package com.example.demo;

import java.util.Scanner;

public class ReverseString {

	public static void main(String args[]) {
		/*
		 * Scanner sc = new Scanner(System.in); // String str = sc.nextLine(); String
		 * reverse =""; // for (int i = str.length()-1; i >=0; i--) { // // reverse =
		 * reverse + str.charAt(i); // // // }
		 * 
		 * // StringBuilder sb = new StringBuilder(str); //// for (char ch :
		 * str.toCharArray()) { }
		 */
  String st = "2020-03-27";
		java.util.Date utilDate = new java.util.Date(st);
		System.out.println("Util date in Java : " + utilDate);
		// contains only date information without time
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(utilDate.getTime());
		System.out.println(utilDate.getTime());
		System.out.println(utilDate.toString());

		// Read more:
		// https://www.java67.com/2014/02/how-to-convert-javautildate-to-javasqldate-example.html#ixzz6HeeFxRAT

		//System.out.println("Reversed String " + sb.reverse());
	}

}
