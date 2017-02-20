package ArraysAndStrings;

import java.util.Scanner;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 * @author prateek
 *
 */
public class Five_ReplaceSpaceWith020 {
	//Time Complexity O(n) and space complexity O(n+ s*3) s is number of space.
	//This method is using O(n) extra space than required
	public static String replaceSpaceWithPercent20(String s){
//		return s.replaceAll(" ", "%20");
		StringBuilder result = new StringBuilder();
		for(char c:s.toCharArray()){
			if(c == ' '){
				result.append("%20");
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}
	/**
	 * if String is in the form of character
	 * @param args
	 */
	public static void replaceSpaceInPlace(char[] s, int length){
//		int n = s.length;
		int noOfSpaces = 0;
		for(int i=0;i<length;i++){
			if(s[i]==' ') noOfSpaces++;
		}
		int newLength = length+noOfSpaces*2;
		s[newLength-1] = '\0';
		for(int i=length-1,j=newLength-1;i>=0 && j>=0;i++){
			if(s[i]==' '){
				s[j--]='0';
				s[j--]='2';
				s[j--]='%';
			}else{
				s[j--]=s[i];
			}
		}
		
		for(char c:s){
			System.out.print(c);
		}
	}
	public static void main(String[] args) {
//		String s = "p s";
		char[] s = new char[1000];
		int i=0;
		Scanner in = new Scanner(System.in);
		for( i=0;i<1000 && i!='\n';i++){
			s[i]= in.next().charAt(0);
		}
		replaceSpaceInPlace(s,i+1);
//		System.out.println(replaceSpaceInPlace(s.toCharArray()));
	}
}
