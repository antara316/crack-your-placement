class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(nums[i],max);
        }
        int high = max;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(sumDivisor(nums,mid) <= threshold)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return ans;
    }

    public int sumDivisor(int nums[] , int mid)
    {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += Math.ceil((double)nums[i]/(double)mid);
        }

        return sum;
    }
}