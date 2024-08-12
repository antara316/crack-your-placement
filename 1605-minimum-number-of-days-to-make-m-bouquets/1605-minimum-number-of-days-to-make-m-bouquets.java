class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            max = Math.max(bloomDay[i],max);
            min = Math.min(bloomDay[i],min);
        }

        int ans = -1;
        int low = min;
        int high = max;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k)==true)
            {
                ans = mid;
                high = mid-1;
            }else
            {
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean  possible(int bloomDay[],int mid,int m,int k)
    {
        int count =0;
        int total = 0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            {
                count++;
            }
            else
            {
                total = total + (count)/k;
                count =0;
            }
        }

        total = total + (count)/k;

        if(total >= m)
        {
            return true;
        }

        return false;
    }
}