class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if(nums.length == 1) return nums[0];
        if(nums[low]!=nums[low+1]) return nums[low];
        if(nums[high]!=nums[high-1]) return nums[high];
        low = 1;
        high = high-1;
        while(low<=high)
        {
            int mid = (low + high)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
            {
                return nums[mid];
            }

            if(((mid % 2)==1 && nums[mid-1]==nums[mid])|| ((mid % 2)==0 && nums[mid]==nums[mid+1]))
            {
                low = mid + 1;
            }else
            {
                high = mid-1;
            }
        }

        return -1;
    }
}