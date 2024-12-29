//TC: O(log n), two binary searches
//SC: no extra space - O(1)

//approach: first doing one binary search over array to find first position of target
// second binary search to find last position of target
public class FirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(null == nums || nums.length ==0 ||
                target < nums[0] || target > nums[nums.length -1])
            return new int[] {-1,-1};

        int firstPosition = binarySearchFirst(nums, target);
        if(firstPosition == -1) return new int[] {-1,-1};
        int lastPosition = binarySearchLast(nums, target);
        return new int[] {firstPosition, lastPosition};
    }

    int binarySearchFirst(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid-1] != target) return mid;
                else high = mid-1;
            } else if(nums[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    int binarySearchLast(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid+1] != target) return mid;
                else low = mid+1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
