class Solution {
    public int sumSubarrayMins(int[] arr) {
        int nse[] = findnse(arr);
        int psee[] = findpsee(arr);
        long total = 0 ;
        int mod = (int) 1e9 +7;
        int n = arr.length;
        for(int i = 0 ; i<= n-1 ; i++)
        {
            int left = i- psee[i];
           int  right = nse[i] - i;
            total = (total + (long)(left * right * (long)arr[i])% mod)% mod;
        }

        return (int)total;
    }

    public static int [] findnse(int arr[])
    {
        Stack <Integer> st = new Stack<>();
        int n = arr.length;
        int nse[] = new int[n];

        for(int i = n-1 ; i>= 0 ; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public static int[] findpsee(int arr[])
    {
        int n = arr.length;
        int psee[] = new int[n];  
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<= n-1 ; i++)
        {
            while(!st.isEmpty() && arr[st.peek()]> arr[i])
            {
                st.pop();
            }
            psee[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        } 

        return psee;
    }
}