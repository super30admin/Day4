//time complexity : O(log(n)) n=length of nums
//space complexity ; O(1)
//I don't face any problems
//runs successfully on leetcode


public class FindMinimumInRotatedSortedArray153LeetCode {

    public int findMin(int[] nums) {

        int start = 0, end = nums.length - 1;
        while(start<=end){                                      //continue looping when start <=end

            if(nums[start] <= nums[end]){                               //check the array/subarray is sorted
                return nums[start];                                     //if sorted then return start
            }

            int mid = start + (end - start)/2;                              //calculate mid

            if(mid!=0 && nums[mid-1]>nums[mid]){                            //check if mid is the pivot element or not
                return nums[mid];
            }

            if(nums[start] <= nums[mid]){                           //left part is sorted then we have to move right
                start = mid + 1;
            }
            else{                                                   //right part sorted so we have to move left
                end = mid - 1 ;
            }

        }
        return -5001;

    }


}
