//Runtime=1ms
//memory usage:46MB
//Time complexity O(N) N is the number of elements in an array
//sent the arr to -1,-1 by default.
//found the mid element when low is less than or equal to high
//if mid value less than target then shift low to mid+1
//if mid value greater than target then shift high to mid-1
//if target equal to mid value then check low value and if it is less low++
//if target equal to mid value then check high value and if it is more high--
//if both nums[low] and nums[high] values are equal to target  then push low and high into the array and return it
//if low > high . it comes out of while loop and returns -1,-1


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1,mid;
        int[] arr = new int[]{-1,-1};
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high =mid-1;
            }
            else{
                if(nums[low]<target){
                    low=low+1;
                }
                if(nums[high]>target){
                    high=high-1;
                }
                if(nums[low]==target && nums[high]==target){
                     arr[0]=low;
                    arr[1]=high;
                    return arr;
                }
            }
        }
        
        return arr;
        
    }
}