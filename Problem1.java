public class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        if (nums[0] > target || nums[nums.length-1] < target) {
            return new int[]{-1, -1};
        }
        int first_occur = searchFirstOccur(nums, target);
        int last_occur = searchLastOccur(nums, first_occur, nums.length - 1, target);
        return new int[]{first_occur, last_occur};
    }
    
    public static int searchFirstOccur(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if (nums[mid] == target){
                if (mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    h = mid - 1;
                }
            }
            else if (nums[mid] > target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
            
        }
        return -1;
    }
    
    public static int searchLastOccur(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l)/2;
            if(nums[mid] == target){
                if (mid == nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    l = mid + 1;
                }
            }
            else if (nums[mid] > target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }

}