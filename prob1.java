class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int first = findfirst(nums, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int last = findlast(nums, target);
        return new int[]{first, last};
    }
    private int findfirst(int[] nums,int target){
        int low = 0; 
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid -1] != target){
                    return mid;
                }
                high = mid -1;
            } else if(target > nums[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
    
    private int findlast(int[] nums, int target){
        int low = 0; 
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid +1] != target){
                    return mid;
                }
                low = mid+1;
            }else if(target > nums[mid]){
                low = mid +1;
            }else{
                high = mid-1;
            }
    }
        return -1;
    }
}
