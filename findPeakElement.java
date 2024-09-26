class Solution {
    public int findPeakElement(int[] nums) {

        int low=0;
        int high=nums.length-1;
        int mid;
        if(high==0){
            return 0;
        }
        while(low<=high){
            mid=low+(high-low)/2;
            System.out.println("mid , low , high = " +mid +" " +low + " "+high +" ");
            if( mid!=0 && nums[mid-1]<nums[mid] && mid!=nums.length-1 && nums[mid+1]<nums[mid]){
                return mid;
            }else if(mid==0 && nums[mid+1]<nums[mid] || mid==nums.length-1 && nums[mid-1]<nums[mid]){
                return mid;
            }

            else{
                if(nums[mid+1]>nums[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }

            }
        }
        return 324234;
    }}