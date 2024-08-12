class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<weights.length;i++)
        {
            max = Math.max(weights[i],max);
            sum+=weights[i];
        }

        int low = max;
        int high = sum ;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int numDays = fullfill(weights,mid);
            if(numDays <= days)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

        }
        return low;
    }

    public int fullfill(int nums[],int mid)
    {
        int days = 1;
        int load =0;
        for(int i=0;i<nums.length;i++)
        {
            if(load + nums[i] > mid)
            {
                days = days+1;
                load = nums[i];
            }else
            {
                load += nums[i];
            }
        }

        return days;
    }
}