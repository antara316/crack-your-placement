class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }

    public void backtrack(int nums[],int start,List<Integer> arr, List<List<Integer>>result)
    {
        result.add(new ArrayList<>(arr));
        for(int i=start;i<nums.length;i++)
        {
            arr.add(nums[i]);
            backtrack(nums,i+1,arr,result);
            arr.remove(arr.size()-1);
        }
        
    }

}