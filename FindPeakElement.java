// Time Complexity : O(log n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No

 class Solution {
     public int findPeakElement(int[] nums) {
         int left=0,right=nums.length-1,mid=0;  //initialize the left and the right boundaries
         while(left<right){
             mid=left+(right-left)/2;   //calculate the value of mid to avoid integer overflow
             if(nums[mid]>nums[mid+1])   right=mid; //checks whether the current element is greater than the next element and update the right index
             else    left=mid+1;  //else update the left index
         }
         return left;   //returns the index of the peak element
     }
 }

class FindPeakElement{
  public static void main(String args[]){
    Solution sol=new Solution();
    int arr[]=[1,2,1,3,5,6,4];
    System.out.println(sol.findPeakElement(arr)); //returns 5
  }
}
