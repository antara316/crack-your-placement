class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subset = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int num = 0 ; num<=subset-1;num++)
        {
            List<Integer>Lp = new ArrayList<>();
            for(int i = 0 ;i<n;i++)
            {
                if((num & (1<<i)) != 0)
                {
                    Lp.add(nums[i]);
                }
            }

            ans.add(Lp);
        }

        return ans;
    }
}