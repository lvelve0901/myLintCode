package test;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    
	public static int lengthOfLongestSubstring(String s) {
        // write your code here
    	
		int ans = 0;
		int i = 0, j = 1;
		int cur = 1; // current length
		
		HashSet<Character> unique = new HashSet<Character>();
		
		if (s.length() < 1) {
			return ans;
		}
		else {
			ans += 1;
		}
		
		unique.add(s.charAt(0));
		for (i = 0; i < s.length(); i++) {
			while( j < s.length()) {
				if (!unique.contains(s.charAt(j))) {
					unique.add(s.charAt(j));
					cur += 1;
					j += 1;
				}
				else break;
			}
			
			ans = Math.max(cur, ans);
			unique.remove(s.charAt(i));  // remove the first element from the unique hashset
			cur -= 1; // current length -1 when move the window to the next position
		}
		
		
		return ans;
		
    	
    }
	
	public static void main(String[] args) {
		String s = "aaaa";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}
	
}
