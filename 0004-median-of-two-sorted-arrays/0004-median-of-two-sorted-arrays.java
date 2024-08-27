class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int ind2 = n /2;
        int ind1 = ind2-1;
        int idx1 = -1, idx2 = -1;
        int count =0;
        int i=0 , j =0;
        while(i<n1 && j<n2)
        {
            if(nums1[i]<nums2[j])
            {
                if(count == ind1) idx1 = nums1[i];
                if(count == ind2) idx2 = nums1[i];
                count++;
                i++;
            }
            else
            {
                if(count == ind1) idx1 = nums2[j];
                if(count == ind2) idx2 = nums2[j];
                count++;
                j++;
            }

            if(idx1!=-1 && idx2!=-1)
            {
                break;
            }
            
        }

        while(i<n1)
        {
            if(count == ind1) idx1 = nums1[i];
            if(count == ind2) idx2 = nums1[i];
            count++;
            i++;
        }

        while(j<n2)
        {
            if(count == ind1) idx1 = nums2[j];
            if(count == ind2) idx2 = nums2[j];
            count++;
            j++;
        }

        if(n%2 == 1)
        {
            return (double) idx2;
        }

        return (double)((double)(idx1+idx2)) /2.0;

    }
}