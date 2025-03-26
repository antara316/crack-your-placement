class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack < Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i =0 ; i< n ;i++)
        {
            while(!st.isEmpty() && heights[st.peek()] > heights[i])
            {
                int element = st.pop();
                int nse = i ;
                int pse = st.isEmpty()? -1 : st.peek();
                maxArea = Math.max(maxArea , ((nse-pse-1)*heights[element]));
            }

            st.push(i);
        }

        while(!st.isEmpty() )
        {
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea , ((nse-pse-1)*heights[element]));
        }

        return maxArea;
    }
}