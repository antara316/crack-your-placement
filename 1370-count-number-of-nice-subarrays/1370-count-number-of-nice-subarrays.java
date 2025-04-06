class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k) - count(nums , k-1);
    }

    public static int count(int nums[] , int k)
    {
        if(k < 0) return 0;

        int l = 0 , r= 0 , sum = 0 , count = 0;
        while(r<nums.length)
        {
            sum += nums[r]%2;
            while(sum > k)
            {
                sum -= nums[l]%2;
                l = l+1;
            }

            count = count + (r-l+1);
            r = r+1;
        }

        return count;
    }
}