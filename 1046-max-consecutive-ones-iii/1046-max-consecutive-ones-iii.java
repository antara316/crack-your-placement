class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 ;
        int right = 0;
        int len = 0 , maxlen =0;
        int zeros = 0;
        while(right < nums.length)
        {
            if(nums[right] == 0) zeros++;
            if(zeros > k)
            {
                if(nums[left]==0) zeros--;
                left++;
            }

            if(zeros <= k)
            {
                len = right - left +1 ;
                maxlen = Math.max(len , maxlen);
            }

            right++;
        }

        return maxlen;
    }
}