class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atleastK(nums, k)-atleastK(nums, k-1);
    }

    public int atleastK(int[] arr, int k) {

        if(k==0) return 0;
        int l=0, ans=0;
        Map<Integer, Integer>map=new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while(map.size() > k) {
                int x=map.get(arr[l]);
                if(x==1) map.remove(arr[l]);
                else map.put(arr[l], x-1);
                l+=1;
            }

            ans+=(i-l+1);
        }

        return ans;
    }
}