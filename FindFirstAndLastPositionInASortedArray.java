//Time - O(log n)
//Space - O(1)
public class FindFirstAndLastPositionInASortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int first = getFirst(nums, target);
        int last = getLast(nums, target);
        return new int[]{first, last};
    }

    private int getFirst(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(nums[mid]==target){
                if(mid>0 && nums[mid-1]==nums[mid]){
                    high = mid-1;
                } else{
                    return mid;
                }
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    private int getLast(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(nums[mid]==target){
                if(mid<nums.length-1 && nums[mid]==nums[mid+1]){
                    low = mid+1;
                } else{
                    return mid;
                }
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}

