class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l =0, r=0;
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r <n)
        {
            if(s[l] >= g[r])
            {
                r++;
            }
            l++;
        }

        return r;
    }
}