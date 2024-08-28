class Solution {
    public int maxElem(int[][] arr,int col){
        int max=Integer.MIN_VALUE;
        int row=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i][col]){
                max=arr[i][col];
                row=i;
            }
        }
        return row;
    }
    public int[] findPeakGrid(int[][] mat) {
        int low=0;
        int high=mat[0].length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=maxElem(mat,mid);
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=mid+1<mat[0].length?mat[row][mid+1]:-1;
            if(mat[row][mid]>left&&mat[row][mid]>right) return new int[]{row,mid};
            else if(mat[row][mid]<left) high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
}