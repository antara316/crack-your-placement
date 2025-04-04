class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0 ;
        Set<Character> st = new HashSet<Character>();
        int max = Integer.MIN_VALUE;
        for(int r = 0 ;r < s.length() ; r++)
        {
            if(st.contains(s.charAt(r)))
            {
                while(left<r && st.contains(s.charAt(r)))
                {
                    st.remove(s.charAt(left));
                    left++;
                }
            }

            st.add(s.charAt(r));
            max = Math.max(max , r-left+1);
        }

        return max;
    }
}