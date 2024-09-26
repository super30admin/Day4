class Solution {
    public int findMin(int[] nums) {
        
        
        int l=0;
        int h = nums.length-1;
        
        if(nums[l]<=nums[h]){
            return nums[0];
        }
        
        return binarySearch(nums,l,h);
        

        
        
    }
    
    private int binarySearch (int[] nums, int l,int h){

        
        int mid = l+(h-l)/2;
        
        if (mid < h && nums[mid+1] < nums[mid])
            return nums[mid+1];
        
        if (mid > l && nums[mid] < nums[mid - 1])
            return nums[mid];
        
        if (nums[h] > nums[mid])
            return binarySearch(nums, l, mid-1);
        return binarySearch(nums, mid+1, h);
    }
    
}