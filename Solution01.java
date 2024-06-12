//Time-complexity: O(log n)
//Space-complexity: O(n)
class Solution01 {
    public int binarySearchLeft(int[] nums, int target){
            int low = 0;
            int high = nums.length -1;
         while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
        
    public int binarySearchRight(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
         while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]>target){
                high= mid-1;
            }
            else{
                low=mid+1;
            }
         }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        if(nums[0]> target || nums[nums.length-1]<target) return new int[]{-1,-1};
        int left = binarySearchLeft(nums, target);
        if(left == -1) return new int[]{-1,-1};
        int right= binarySearchRight(nums, target);
        return new int[]{left,right};
    }
}