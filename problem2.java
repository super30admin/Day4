// time complexity - O(n)
// space complexity - O(1)
class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end= nums.length-1;
        int mid;
        int n=nums.length;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]<nums[end]){
            return nums[0];
        }
        while(start<=end){
            mid=start + (end-start)/2;
            if(nums[mid]<nums[(mid-1+n)%n] && nums[mid]<nums[(mid+1)%n]){
                return nums[mid];
            }
            if(nums[0]<=nums[mid]){ // checking for the left sorted part
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}