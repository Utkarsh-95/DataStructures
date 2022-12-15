package divideAndConquer;

public class LongestCommonSubsequence_DC {

	public int findLCSLength(String s1, String s2) {
		return findLCSLengthAux(s1, s2, 0, 0);
	}//end of method

	
	private int findLCSLengthAux(String s1, String s2, int index1, int index2) {
		if (index1 == s1.length() || index2 == s2.length())//Base Case
			return 0;
		
		int c3 = 0;
		if (s1.charAt(index1) == s2.charAt(index2)) {//If current character in both the string matches, then increase the index by 1 in both the strings.
			c3 = 1 + findLCSLengthAux(s1, s2, index1 + 1, index2 + 1);
		}

		int c1 = findLCSLengthAux(s1, s2, index1, index2 + 1);//Increase index of 2nd String
		int c2 = findLCSLengthAux(s1, s2, index1 + 1, index2);//Increase index of 1st String
		
		return Math.max(c3, Math.max(c1, c2));
	}//end of method

	
	public static void main(String[] args) {
		LongestCommonSubsequence_DC lcs = new LongestCommonSubsequence_DC();
		System.out.println(lcs.findLCSLength("houdini", "hdupti"));
	}//end of method
	
}//end of class