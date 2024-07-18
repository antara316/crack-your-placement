class Solution {
    public int majorityElement(int[] nums) {
        int major = nums.length /2;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            for(int j=1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }

            if(count>=major)
            {
                return nums[i];
            }
        }

        return -1;

    }
}