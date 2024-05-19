// Time complexity - O(log n)
//space complexity - O(1)
//locate the middle element, if the middle element is equal to the target it might still not be th first occurrence. 
//check if the previous element is also the same value. If yes, narrow down the search to the first half. Otherwise to the right half. 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }
        int first = findFirst(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = searchSecond(nums,target);
        return new int[]{first,second};
    }
       
    public int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
        int mid = low + (high-low) / 2;
        if(nums[mid] == target){
            if(mid == 0 || nums[mid-1] != target){
                return mid;

            }
            else{
                high = mid - 1;
            }
        }
        else if(target > nums[mid]){
                low = mid + 1;
        }
        else{
                high = mid - 1;
            }
        }
        
    return -1;  
    }

    public int searchSecond(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid+1] != target){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if (target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    return -1;
    }
    }
