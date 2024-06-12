class Solution {

    //Time Complexity-0(log n)
    //Space Complexity- 0(1)
    //Did it successfully run on leetcode : Yes
    //Did you face any problem while: No


    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }
        int FirstOccurence = BinarySearchFirst(nums, target);
        if(FirstOccurence == -1){
            return new int[] {-1,-1};
        }
        int SecondOccurence = BinarySearchSecond(nums, target);
        return new int[] {FirstOccurence, SecondOccurence};
    }
    public int BinarySearchFirst(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int BinarySearchSecond(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}