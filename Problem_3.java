// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] a) {
        int low = 0;
      int high = a.length -1 ;
      int n = a.length;
      
      while(low <= high){
        int mid = low + (high - low)/2;
        if((mid == 0 || a[mid] > a[mid-1]) && (mid == n-1 || a[mid] > a[mid+1])){ // mid can never be  < 0 or > n-1, hence the if mid != 0, then mid WILL be > 0 OR < n-1 at any given point of time
          return mid;
        }
        else if(a[mid] < a[mid+1]){
          low = mid + 1;
        }else /*if(a[mid] < a[mid-1])*/{
          high = mid -1;
        }
      }
      return -1;
      
    }
}
