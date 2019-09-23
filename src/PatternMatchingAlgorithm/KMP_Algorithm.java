package PatternMatchingAlgorithm;

/**
 * Knuth Morris Pratt Algorithm:
 *  - It uses degenerating property(pattern having same subpattern
 *    appearing more than once in a pattern)
 *  - Logic: Store data such that if any pattern we are computing
 *           again due to any reason should not be computed.(This is
 *           the only way in which we can save the time of computation)
 */
public class KMP_Algorithm{
	// Finding LPS array
	// LPS: Longest proper prefix which is also suffix
	public static int[] computeLPSArray(String pattern){
		int n=pattern.length(); // getting the length of the string
		int[] lps=new int[n];   // variable declaration to store the lps array


		int len=0;// length of previous longest suffix matching to the prefix
		int i=1;  // index to traverse the whole pattern
		lps[0]=0; // base case

		while(i<n){
			/**
			 * If you get a match in the pattern then store the length of the
			 * pattern matched till that index in the lps array.
			 */
			if(pattern.charAt(i)==pattern.charAt(len)){
				++len;
				lps[i]=len;
				++i;
			}else{ /** In case no match is found then we have to check for 2 conditions */
				/**
				 * If a match exists before that point then find the length of the index
				 * until which it has been matched, then use that index to match the current
				 * character is found until that character is found or it reaches till the end.
				 */
				if(len!=0){
					len=lps[len-1]; // No match, let's try our luck till previous match
				}else{
					lps[i]=len; // Put 0 i.e. no match is possible
					++i; // Increment i
				}
			}
		}
		return lps;
	}
	public static void KMP_Search(String text, String pattern){
		int M=pattern.length();
		int N=text.length();

		int lps[]=computeLPSArray(pattern); // To store the value of the LPS
		int j=0;// to take care of the indexing of the lps

		int i=0;// to take care of the indexing of the text
		while(i<N){
			if(text.charAt(i)==pattern.charAt(j)){
				++i;
				++j;
				if(j==M){
					System.out.println("Found pattern at index "+(i-j));
					// To find the length of the longest suffix which is the
					// prefix till the last character of the pattern
					j=lps[j-1];
				}
			}else if(text.charAt(i)!=pattern.charAt(j)){
				// As there are j-1 matches let's see if the jth match
				// corresponds to the jth character of pattern
				if(j!=0)
					j=lps[j-1];
				// In case no match found then start from the 0th index of the pattern
				else ++i;
			}


		}
	}
	public static void main(String[] args){
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		KMP_Search(text,pattern);
	}
}
