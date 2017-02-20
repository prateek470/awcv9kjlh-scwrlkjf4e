package ArraysAndStrings;
/**
 * 
 * @author prateek
 *
 */
public class Four_StringAnagrams {
	
	/**
	 * In Constant memory
	 */
	public static Boolean Anagrams(String a, String b){
		Integer[] B = new Integer[256];
		for(int i=0;i<B.length;i++)
			B[i]=0;
		for(int i=0;i<a.length();i++){
			B[a.charAt(i)]+=1;
		}
		
		for(int i=0;i<b.length();i++){
			int value = b.charAt(i);
			if(B[value]==0) return false;
			B[value]--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(Anagrams("cat","tace"));
	}
}
