package com.luv2code.jdbc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Checkhy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a[]= {2,3,7,8,1,4,6,9};
		/*
		 * for(int i =1;i<=10;i++) { Scanner sc= new Scanner(System.in); int a=
		 * sc.nextInt();
		 * 
		 * }
		 */
		
		IntStream sder=Arrays.stream(a);
		System.out.println(sder);
		
		}
}