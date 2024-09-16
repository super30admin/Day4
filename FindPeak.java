class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        
        if(nums == null || nums.length ==0 ) return -1;
        
        while(low<= high){
            int mid = low + (high -low)/2;
            //if mid is greater than both of its sides return mid as peek element
            if( (mid == 0 ||nums[mid] > nums[mid -1] )&& 
               (mid == nums.length - 1 ||nums[mid] > nums[mid+1]) ){
                return mid;
            }
            else if(mid >0 && nums[mid] <nums[mid -1]){
                    high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return -1;
    }
}