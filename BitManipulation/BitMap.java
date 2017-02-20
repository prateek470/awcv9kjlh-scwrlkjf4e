package BitManipulation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

/**
 * 
 * @author prateek
 *
 */
public class BitMap {
	/**
	 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
		method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
		N located at i and starting at j).
		EXAMPLE:
		Input: N = 10000000000, M = 10101, i = 2, j = 6
		Output: N = 10001010100
	 * @param args
	 */
	public static void changeAllBitsFromiToj(int m, int n, int i, int j){
		int max = ~0;
		int left = max - ((1<<j)-1);
		int right = (1<<i)-1;
		int mask = left|right;
		
		n = (n&mask)|(m<<i);
		System.out.println(Integer.toBinaryString(n));
	}
	
	/**
	 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation.
If the number can not be represented accurately in binary, print “ERROR”
	 * @param args
	 */
	public static void convertDecimalToBinary(String s){
		String result = "";
		int int_part = Integer.parseInt(s.substring(0,s.indexOf(".")));
		double decimalPart = Double.parseDouble(s.substring(s.indexOf("."),s.length()));
		
		while(int_part>0){
			int temp = int_part%2;
			int_part /=2;
			result = temp+result;
		}
		StringBuffer dec = new StringBuffer();
		while(decimalPart>0){
			if(dec.length()>32) {
				System.out.println("Error");
				return;
			}
			if(decimalPart==1){
				dec.append(1);
				break;
			}
			decimalPart = 2*decimalPart;
			if(decimalPart>=1){
				dec.append(1);
				decimalPart -=1;
			} else {
				dec.append(0);
			}
		}
		System.out.println(result+"."+dec.toString());
	}
	
	/**
	 * Given an integer, print the next smallest and next largest number that have the same
number of 1 bits in their binary representation.
	 * @param args
	 */
	public static void FindSmallestAndLargest(Integer num){
		int numberOfBits = Integer.bitCount(num);
		int min = num-1;
		while(Integer.bitCount(min)!=numberOfBits){
			min--;
		}
		
		int max = num+1;
		while(Integer.bitCount(max)!=numberOfBits){
			max++;
		}
		System.out.println(min+" "+max);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	/**
	 * Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
	 * @param args
	 */
	public static void swapBits(int n){
		//always think about masking
		System.out.println(Integer.toBinaryString(n));
		int mask1 = 0xaaaaaaaa;
		int mask2 = 0x55555555;
		
		n = ((n & mask1)>>1)|((n & mask2)<<1);
		System.out.println(Integer.toBinaryString(n));
	}
	
	/**
	 * An array A[1...n] contains all the integers from 0 to n except for one number which is
missing. In this problem, we cannot access an entire integer in A with a single operation.
The elements of A are represented in binary, and the only operation we can use
to access them is “fetch the jth bit of A[i]”, which takes constant time. Write code to
!nd the missing integer. Can you do it in O(n) time?
	 * @param args
	 */
	//column is the size of the Bit Integer
	public static int findMissingNumber(ArrayList<BitInteger> A, int column){
		if(column < 0){
			return 0;
		}
		
		ArrayList<BitInteger> evenBits = new ArrayList<>();
		ArrayList<BitInteger> oddBits = new ArrayList<>();
		
		for(BitInteger i : A){
			if(i.fetch(column)==0){
				evenBits.add(i);
			}else{
				oddBits.add(i);
			}
		}
		
		if(oddBits.size() >= evenBits.size()){
			return findMissingNumber(evenBits, column-1)<< 1|0;
		} else {
			return findMissingNumber(oddBits, column-1)<< 1|1;
		}
	}
	public static void main(String[] args) {
		ArrayList<BitInteger> A = new ArrayList<>();
		A.add(new BitInteger(1));
		A.add(new BitInteger(2));
		A.add(new BitInteger(0));
		System.out.println(findMissingNumber(A, BitInteger.INTEGER_SIZE - 1));
	}
}
