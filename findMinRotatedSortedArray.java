// Time Complexity : O(logn)
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Bruteforce for this would be two pointers and checking the min element in the array. TC= O(n^2);
// Your code here along with comments explaining your approach 

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
	
        while(low < high){
            int mid = low+(high-low)/2;
	    //rotatedSortedArray, so check whether mid element is less than high, if it is then discard the first subhalf
            if(nums[high] <= nums[mid]){
                low = mid+1;
            }
	    //if mid is not less than high, then discard the second subhalf
            else
                high = mid;
        }
        //always return the lowest element thus check low
        return nums[low];
    }
} 

/*
//TwoPointerMethod

class Solution {
    public int findMin(int[] nums) {
        int temp = nums[0];
        for(int i = 0; i < nums.length-1;i++){
            for(int j = 1; j <= nums.length-1;j++){
                if(nums[i] < nums[j] && temp > nums[i]){
                    temp = nums[i];
                }
                else if(nums[i] > nums[j] && temp > nums[j]){
                    temp = nums[j];
                }
            }
        }
        return temp;
    }
} 

*/