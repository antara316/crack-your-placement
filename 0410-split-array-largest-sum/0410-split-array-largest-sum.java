class Solution {
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        for(int i=0;i<nums.length;i++)
        {
            low = Math.max(low,nums[i]);
            high = high + nums[i];
        }

        while(low<=high)
        {
            int mid = (low+high)/2;
            if(partitionCount(nums,mid) > k)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        return low;
    }

    public int partitionCount(int nums[],int k)
    {
        int partition = 1;
        long subarrsum = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(subarrsum + nums[i] <= k)
            {
                subarrsum += nums[i];
            }else
            {
                partition++;
                subarrsum = nums[i];
            }
        }
        return partition;
    }
}