// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Iterative binary search
public class Problem3FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low=0; int high=nums.length-1;
         while(low<=high){
         int mid=low+(high-low)/2;
             if((mid==low || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                 return mid;
             }else if(mid>low && nums[mid]<nums[mid-1]){
                 high=mid-1;
             }else low=mid+1;
         
     }
     return -1; 
     }
}
