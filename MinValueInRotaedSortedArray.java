//Run time 1 ms
//Time compl O(LogN) N elemets in an array

//calculate mid value
//First check if low is equal to high . if yes return that nums[mid] value.
//check if value at middle is greater than or equal to value at low --- to find which part of the array is sorted
    //if yes then check whether 
    //value at low is less than value at high --- fully sorted array. then make high to mid-1
    //else low=mid+1
//else increment low forward
//return value at mid when low>high




class Solution {
    public int findMin(int[] nums) {
         int low=0,high=nums.length-1,mid;
        mid=low+(high-low)/2;
        while(low<=high){
            mid=low+(high-low)/2;
            if(low==high){
                  return nums[mid];
            }
            if(nums[mid]>=nums[low]){
                if(nums[low]<nums[high]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                low=low+1;
            }
        }
        return nums[mid];
    }
}