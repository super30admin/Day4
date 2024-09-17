// Time Complexity : O(log n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1,mid=0; //initialize left and right boundaries
        while(left<right){
            mid=left+(right-left)/2;  //calculate mid pointer to avoid integer overflow
            if(nums[mid]>nums[right]){  //if element at mid index is greater than the element at right index, reduce the search space by half by updating left index
                left=mid+1;
            }else   right=mid;  //else update right
        }
        return nums[left];  //the element at index left would be the smallest element in the array hence return the element at left index
    }
}
class FindMinInRotatedSortedArray{
  public static void main(String args[]){
    Solution sol=new Solution();
    int arr[]={6,7,8,9,0,1,2};
    System.out.println(sol.findMin(arr));
  }
}
