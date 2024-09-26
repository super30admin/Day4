//time complexity : O(log(n)) n=length of nums
//space complexity ; O(1)
//I don't face any problems
//runs successfully on leetcode



public class FindPeakElement162LeetCode {

    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start<=end){
            int mid = start + (end - start)/2;                                                  //calculating mid

            boolean midGreaterThanRight = mid==nums.length-1 || nums[mid] > nums[mid+1];           //check if mid is higher than its right element
            boolean midGreaterThanLeft = mid==0 || nums[mid] > nums[mid-1];                         //check if mid is higher than its left element

            if(midGreaterThanRight && midGreaterThanLeft){              //if mid is higher from left and right element then return mid
                return mid;
            }

            if(midGreaterThanRight){                    //if mid is higher than its right element then go left
                end = mid - 1;
            }
            else{                                   //if mid is higher than its left element then go right
                start = mid + 1;
            }

        }
        return -1;

    }


}
