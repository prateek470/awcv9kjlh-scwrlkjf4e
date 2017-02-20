package ArraysAndStrings;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author prateek
 *	Texas A&M University
 */
public class One_StringUniqueChar {
	/**
	 * This algorithm will take O(n^2) but no extra space
	 */
	public static Boolean UniqueChar_O_n_square(String s) {
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This algorithm will take O(n*log n) but o(n) extra space 
	 */
	public static Boolean UniqueChar_O_N_logN(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for(int i=0;i<c.length-1;i++){
			if(c[1]==c[i+1]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Lets assume that char is ASCII O(n) time complexity and O(1) space 
	 */
	public static Boolean UniqueChar_ASCII_O_N(String s) {
		Boolean[] B = new Boolean[256];
		for(int i=0;i<B.length;i++)
			B[i]=false;
		for(int i=0;i<s.length();i++){
			int value = s.charAt(i);
			if(B[value]) return false;
			B[value]=true;
		}
		return true;
	}
	
	/**
	 * Using Bit operator to reduce the space complexity from 256 char to one int
	 * We will assume that string has char from 'a' to 'z'
	 * This will make use of the concept that int use 8 Byte we are using it 
	 */
	public static Boolean UniqueChar_Bit_O_N(String s) {
		int check = 0;
		for(int i=0;i<s.length();i++){
			int value = s.charAt(i)-'a';
			System.out.println(value);
			if((check & 1<<value) > 0) return false;
			check |= 1<<value;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(UniqueChar_Bit_O_N("waea"));
	}
}
