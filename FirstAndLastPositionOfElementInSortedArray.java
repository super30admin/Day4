// Time Complexity : O(log n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=binarySearch(0,nums.length,nums,target);
        if(nums.length==0 || start==nums.length|| nums[start]!=target)   return new int[]{-1,-1};
        /*
        returns [-1,-1] when array length is 0 or start index matches the array
        length or element at start index is not equal to the target
        */
        return new int[]{start,binarySearch(start,nums.length,nums,target+1)-1};
    }
    public int binarySearch(int left,int right,int[] nums,int target){
        int mid=0;
        while(left<right){
            mid=left+(right-left)/2;  //reduces the search space by half of the array size
            if(nums[mid]<target)    left=mid+1; //if the element at mid index is less than the target update the left
            else    right=mid;
        }
        return left;
    }
}
class FirstAndLastPositionOfElementInSortedArray{
  public static void main(String args[]){
    Solution sol=new Solution();
    int arr[]={5,7,7,8,8,10};
    System.out.println(sol.searchRange(nums));  //return [3,4];
  }
}
