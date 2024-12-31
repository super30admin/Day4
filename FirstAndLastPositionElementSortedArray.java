// Time Complexity: O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

package Interview;

public class FirstAndLastPositionElementSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,4,4,4,5};
		int target = 4;
		
		searchRange(nums, target);
	}
	public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[] {-1,-1};
        }
        if(target < nums[0] || target > nums[nums.length -1]){
            return new int[] {-1,-1};
        }
        
        int first = binarySearchFirst(nums, target);
        System.out.println(first);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = binarySearchLast(nums, target);
        System.out.println(second);
        return new int[] {first, second};
    }

    private static int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high-low)/2; //preventing integer overflow
            if(nums[mid] == target){
                if(mid == 0 || (nums[mid-1] != nums[mid])){
                    return mid;
                }
                high = mid -1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
            
        }
        return -1;
    }

    private static int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if((mid == nums.length -1) || (nums[mid+1] != nums[mid])){
                    return mid;
                }
                low = mid+1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
}
