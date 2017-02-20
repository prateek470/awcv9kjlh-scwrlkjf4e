package ArraysAndStrings;
/**
 * 
 * @author prateek
 *
 */
public class Two_ReverseCstyleString {
	
	/**
	 * Space complexity O(n)
	 */
	public static String reverseString(String s) {
		StringBuilder res = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--){
			res.append(s.charAt(i));
		}
		return res.toString();
	}
	/**
	 * Inplace O(1) space
	 * Can be done only in case of char array 
	 */
	
	
	public static void main(String[] args) {
		System.out.println(reverseString("adaffewfwe\0"));
	}
}
