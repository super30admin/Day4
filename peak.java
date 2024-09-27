/*
time complexity O(log n)
Space complexity O(1)
*/
class Solution {
    public int findPeakElement(int[] nums) {
     int low=0;
     int high=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(low<=high){
         int middle=low+(high-low)/2;
         /* edge conditions*/
         if(middle==0&&nums[middle]>nums[middle+1]){
             return middle;
         }
         if(middle==(nums.length-1)&&nums[middle]>nums[middle-1]){
            return middle;
         }
        /*checking middle*/
            if(nums[middle]>nums[middle+1]&&nums[middle]>nums[middle-1]){
            return middle;
        }
        /*controlling flow*/
        if(nums[middle]<nums[middle+1]){
            low=middle+1;
        }
        else{
            high=middle-1;
        }
        }
        return -1;
    }
    
}