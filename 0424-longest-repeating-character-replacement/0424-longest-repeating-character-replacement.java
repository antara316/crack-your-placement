class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 , r = 0 , maxlen = 0;
        int arr[] = new int[26];
        int maxfr =0 ;

        while(r < s.length())
        {
            arr[s.charAt(r)-'A']++;
            maxfr = Math.max(maxfr , arr[s.charAt(r)-'A']);
            if((r-l+1)- maxfr > k)
            {
                arr[s.charAt(l)-'A']--;
                l = l+1;
            }

            if((r-l+1)-maxfr <= k)
            {
                maxlen = Math.max(maxlen, r-l+1);
                r++;
            }

        }

            return maxlen;
    }
}