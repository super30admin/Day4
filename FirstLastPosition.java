//Time Complexity: O(logn) + O(logn) ~= O(log n)
//Space Complexity: O(1)
//Difficulty:
  //trying to get right result for last indx. was tricky since can get two cases
  //depending on if target is last element or not.
//Leetcode accepted: yes
//Algo description and code with comments:
  //1.to get strt indx binary search on condition nums[mid] >= target,
  //  to reduce search space.
  //2.get strt elem
  //3.to get end indx binary search on condition nums[mid] > target,
  //  to reduce search space.
  //4.get strt (or strt-1 elem if nums[strt] != target)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};

        int ret[] = new int[2];
        int strt = 0;
        int end = nums.length-1;

        //do binary search till condition is true.
        while(strt < end){
            int mid = strt+ ((end-strt)/2);
            //do binary search till condition is true.
            if(nums[mid] >= target)
                end = mid;
            else
                strt = mid+1;
        }

        //in case strt != target, we did not find element, return.
        if(nums[strt] != target){
            return new int[]{-1,-1};
        }


        ret[0] = strt;
        //set strt to prev strt, since we already
        //have strt index and need to search beyond it.
        strt = strt;
        end = nums.length-1;

        //do binary search till condition is true.
        while(strt < end){
            int mid = strt+ ((end-strt)/2);
             //do binary search till condition is true.
            if(nums[mid] > target)
                end = mid;
            else
                strt = mid+1;
        }

        //if nums[strt] != target this point,
        //we know we already found strt indx(so trgt found),
        //reduce strt by 1 to find end indx.
        //can happen in case target is not last elem.
        if(nums[strt] != target)
            strt--;

        ret[1] = strt;
        return ret;
    }
}
