// Time Complexity : O(log(n)) n is the no of elements
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PeakElement {
    public int findPeakElement(int[] nums) {

        int low =0;
        int n = nums.length;
        int high = nums.length-1;
        while(low <=high){
         int mid = low+(high-low)/2;
         if((mid ==0 || nums[mid]> nums[mid-1]) && (mid ==n-1 || nums[mid]>nums[mid+1])){

         return mid;

         }

         else if (mid < n-1 && nums[mid] < nums[mid+1]){

              low = mid+1;

         }else {


            high = mid-1;
         }





        }
          return -1;
    }
}
