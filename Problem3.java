class Solution {
    public int findPeakElement(int[] A) {
        int low = 0;
        int high = A.length-1;

        int mid;

        while(low<high){
            mid = low + (high - low)/2;
            if(A[mid] < A[mid+1])
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}