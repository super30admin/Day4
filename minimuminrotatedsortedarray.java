class Solution {
    public int findMin(int[] nums) {

        int low=0;
        int high=nums.length-1;
        int mid;
        if(high==1){
            if(nums[0]<nums[1]){
                return nums[0];
            }else{
                return nums[1];
            }
        }
        if(nums.length==1){
            return nums[0];
        }


        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[low]<nums[high]) return nums[low];

            if( mid<nums.length-1 && nums[mid]<nums[mid+1] && mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(mid==0&&nums[mid]<nums[mid+1] || mid==nums.length-1 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else{
                if(nums[mid]<nums[high]){
                    high=mid-1;
                }else if(nums[mid]>=nums[low]){
                    low=mid+1;
                }
            }
        }

        return -1;

    }
}