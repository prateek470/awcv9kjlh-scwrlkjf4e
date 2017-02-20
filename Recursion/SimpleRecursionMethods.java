package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursion Algorithms
 * @author prateek
 *
 */
public class SimpleRecursionMethods {
	/**
	 * Write a method to generate the nth Fibonacci number
	 * @param args
	 */
	public static long FibonacciNumber(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		else if(n>1)
			return FibonacciNumber(n-1)+FibonacciNumber(n-2);
		else
			return -1;
	}
	/**
	 * Fibonacci number iterative solution
	 * @param args
	 */
	public static long FibonacciNumberIter(int n){
		if(n<0) return -1;
		if(n==0) return 0;
		long a=1;
		long b=1;
		
		for(int i=3;i<=n;i++){
			long sum = a+b;
			a=b;
			b=sum;
		}
		return b;
	}
	
	/**
	 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can
		only move in two directions: right and down. How many possible paths are there for
		the robot?
		FOLLOW UP
		Imagine certain squares are “o# limits”, such that the robot can not step on them.
		Design an algorithm to get all possible paths for the robot.
	 * @param args
	 */
	public static int pathsFromTopToBottom(int[][] grid){
		if(grid.length==0) return 0;
		
		return pathsToBottom(grid,0,0,grid.length-1);
	}
	
	private static int pathsToBottom(int[][] grid, int i, int j,int size) {
		if(i>size || j>size) return 0;
		if(i==size && j==size){
			return 1;
		}
		else{
			return pathsToBottom(grid, i+1, j, size) + pathsToBottom(grid, i, j+1, size);
		}
		
	}
	public static void main(String[] args) {
		int [][] grid = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		String s = "abc";
		List<Integer> list = new ArrayList<>();
		int[] arr = list.toArray(int[]);
		char[] temp = Arrays.sort(s.toCharArray());
//		System.out.println(pathsFromTopToBottom(grid));
	}
}
