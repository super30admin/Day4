//TC: O(log N)
//SC : O(1)
// Approach: Go away from the sorted array to find the minimum

class Solution {
    public int findMin(int[] n) {
        int l =0; int h = n.length-1; 

        while(l<=h){
            // checks for the case l=h or when we reach the pivot
            if(n[l]<=n[h]) return n[l];

            int mid = l + (h-l)/2;
            // logical operator checks left first and ignores right if satisfied
            if( (mid ==0 || n[mid] < n[mid-1]) && n[mid] < n[mid+1]) return n[mid];
            // if left is sorted, go to right subarray
            else if (n[l]<=n[mid]) l = mid+1;
            // if right is sorted, go to left subarray
            else h = mid-1;
        }

        return -1;
    }
}