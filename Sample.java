// Time Complexity : 0(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only


//Intituion is to do a seperate binary search for first occurence and another binary search for
//second occurance
class firstLastSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first,last;
        if(nums.length==0 || target> nums[nums.length-1]){
            return new int[]{-1,-1};
        }

        first=binarySearchFirst(nums,target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        last =binarySearchLast(nums,target);

        return new int[]{first,last};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if((mid ==0) || (nums[mid] != nums[mid-1])){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else if(nums[mid]< target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if((mid==nums.length-1) || (nums[mid+1]!=nums[mid])){
                    return mid;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}

// Time Complexity : 0(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/* Intuition is to check the unsorted side of the array in case the entire is not sorted return
first element or if both the sides are sorted return mid
 */

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            //check if the entire array is sorted
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            //check if the next and previous elements are sorted
            if(((mid==0) || (nums[mid-1]>nums[mid])) &&
                    ((mid==n-1) || (nums[mid+1]>nums[mid]))){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}

// Time Complexity : 0(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
Intuition is to do a binary search and check if the mid element is peak
If it is , then return it. Else go in the direction of middle element
to find the peak
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(((mid==low)||(nums[mid-1]<nums[mid])) &&
                    ((mid==high)||(nums[mid+1]<nums[mid]))){
                return mid;
            }else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return Integer.MAX_VALUE;
    }
}