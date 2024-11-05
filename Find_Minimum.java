class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        int min=nums[0];

        while(low<=high){
            mid=(high+low)/2;
            if(nums[mid]<min)
               min=nums[mid];
            if(nums[low]<min)
               min=nums[low];
            if(nums[high]<min)
             min=nums[high];
            if(nums[low]<nums[mid] && nums[mid]>nums[high]){
                low=mid+1;
                continue;
            }else if (nums[low]>nums[mid] && nums[mid]<nums[high]){
                high=mid-1;
                continue;
            }
                return min;

            
        }
        return min;
    }
}