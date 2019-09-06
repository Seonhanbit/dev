package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] user_info = new int [4];
		for(int i=0; i<4; i++)
		{
			user_info[i]=sc.nextInt();
		}
		System.out.println(Arrays.toString(user_info));
		}
	}
