class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x < 0)
        {
            x = (-1) * x;
            neg = true;
        }
        int rev =0;
        while(x > 0)
        {
            int rem = x % 10;
            if (rev > (Integer.MAX_VALUE - rem) / 10) {
                return 0;  
            }
            rev = (rev * 10) + rem;
            x = x/10;
        }

        return neg == true? -(rev) : rev;
    }
}