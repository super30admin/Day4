class Solution {
    public int findMin(int[] A) {
        if(A[0] <= A[A.length-1]) //for the case when array is already sorted
            return A[0];
        int low = 0;
        int high = A.length-1;
        int mid;

        while(low<high){
            mid = low + (high-low)/2;

            if(A[mid] > A[high])
                low = mid + 1;
            else
                high = mid;
        }

        return A[low];
    }
}