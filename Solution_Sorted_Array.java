class Solution_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int left,right;
        left = findFirst(nums,n,target);
        right = findLast(nums,n,target);
        
        return new int[] {left,right};
    }
    
    private int findLast(int[] nums,int n,int target){
        int low = 0,high = n-1,index = -1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
            if(nums[mid] == target){
                index = mid;
            }
            }
        return index;
        }
     private int findFirst(int[] nums,int n,int target){
        int low = 0,high = n-1,index = -1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(target > nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid  - 1;
            }
            if(nums[mid] == target){
                index = mid;
            }
            }
        return index;
        }
   
    }
//Time Complexity: O(logn)
//I have ueed 2 methods to find the first and last occurance of the target by doing binary search
