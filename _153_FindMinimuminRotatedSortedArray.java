// space complexity - o(1)
    	//time - o(log(n))
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : Binary Search, divide array in two halves, if mid to end is soorted move end to mid else move start to mid+1
       // one special condition is when start and end are one distance apart that time take min(start, end) 

class Solution {
    public int findMin(int[] nums) {

      if(nums == null || nums.length ==0) return -1;
      if(nums.length == 1) return nums[0];
      if(nums[0] < nums[nums.length-1]) return nums[0];

      int start = 0;
      int end = nums.length-1;
      int mid = start + (end - start)/2;

      while(start <= end){
        mid = start + (end - start)/2;
        if(start == end) return nums[start];

        if(start == mid) return Integer.min(nums[start], nums[end]);

        if(nums[mid] < nums[end]){
          end = mid;
        }
        else{
          start = mid + 1;
        }
      }
      return -1;
    }
}
