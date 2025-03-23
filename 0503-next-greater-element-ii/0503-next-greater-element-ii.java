class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stac=new Stack();
        int[] ans=new int[n];
        Arrays.fill(ans, -1); int k=n-1;
        for(int i=2*n-1; i>=0; i--){
            while(!stac.isEmpty() && nums[i%n]>=stac.peek()){
                stac.pop();
            }
            if(!stac.isEmpty() && i<n){
                ans[i]=stac.peek();
            }
            stac.push(nums[i%n]);
        }
        return ans;
    }
}