//Time Complexity: O(log n)
//Space Complexity: O(1)
//Difficulty:
  //figuring out the relation between mid and last elem.
//Leetcode accepted: yes
//Algo description and code with comments:
  //binary search on condition if nums[mid] > nums[end];
  //if so we know elem lies in laster half.
class Solution {
    public int findMin(int[] nums) {
        int strt = 0;
        int end = nums.length-1;

        while(strt < end){
            int mid = strt+(end-strt)/2;

            if(nums[mid] > nums[end])
                strt = mid+1;
            else
                end = mid;
        }

        return nums[strt];
    }
}
