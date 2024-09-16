//Time Complexity: O(log n)
//Space Complexity: O(1)
//Difficulty:
  //would not have thought of binary search to begin with.
//Leetcode accepted: yes
//Algo description and code with comments:
  //binary search on condition nums[mid] < nums[mid+1]
  //if so, we know peek is right of mid, move strt to right
  //other wise we may be at peek move end to mid.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;

        int strt = 0;
        int end = nums.length-1;

        while(strt < end){
            int mid = strt + (end-strt)/2;

            if(nums[mid] > nums[mid+1])
                end = mid;
            else
                strt = mid+1;
        }
        return strt;
    }
}
