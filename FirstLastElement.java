//Runtime: log(n) + log(n)
//Space Complexity: O(1)
//Passed on Leetcode
//Some difficulty coding, but concept was ok


public class FirstLastElement {
    public int[] searchRange(int[] nums, int target) {
        //edge case
        if(nums.length == 1 && nums[0] == target){
            return new int[] {0,0};
        }
        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }
        if(nums[0] > target || nums[nums.length - 1] < target){
            return new int[] {-1,-1};
        }
        //base case if element not in array
        int[] retVal = {-1,-1};

        //finding first position
        int low1 = 0;
        int high1 = nums.length - 1;

        if(nums[low1] == nums[high1]){
            return new int[] {low1,high1};
        }
        while(low1 <= high1){
            int mid = low1 + (high1 - low1)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    retVal[0] = mid;
                    break;
                }
                else{
                    high1 = mid - 1;
                }
            }
            else if(nums[mid] > target){
                high1 = mid - 1;
            }
            else{
                low1 = mid + 1;
            }
        }


        //find last position
        int low2 = 0;
        int high2 = nums.length - 1;

        while(low2 <= high2){
            int mid = low2 + (high2 - low2)/2;
            if(nums[mid] == target){
                if(nums[mid] < nums[mid+1] || mid == nums.length - 1){
                    retVal[1] = mid;
                    break;
                }
                else{
                    low2 = mid + 1;
                }
            }
            else if(nums[mid] <= target){
                low2 = mid + 1;
            }
            else{
                high2 = mid - 1;
            }
        }
        return retVal;
    }
}