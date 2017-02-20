package ArraysAndStrings;

public class Three_RemoveDuplicateCharInString {
	
	public static char[] RemoveDuplicateChars(char[] s){
		Boolean[] B = new Boolean[256];
		for(int i=0;i<B.length;i++)
			B[i]=false;
		for(int i=0;i<s.length;i++){
			int value = s[i];
			if(B[value]) s[i]=Character.MIN_VALUE;
			B[value]=true;
		}
		return s;
	}
	
	public static void main(String[] args) {
		char[] c = {'a','b','a','c'};
		System.out.println(RemoveDuplicateChars(c));
	}
}
