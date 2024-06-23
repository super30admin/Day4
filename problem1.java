/*first find if target exists in input array using binary search
 * once you find index of any occurance of the target, search the left side for 1st occurance of the index using binary search.
 * Then search the right side for the last index using binary search
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null){
            return new int[]{-1,-1};
        }
        int high = nums.length -1;
        int startIndex = getfirst(nums,target,0,high);
        if(startIndex == -1){
            return new int[]{-1,-1};
        }
        int lastIndex = getLast(nums,target,startIndex,high);
        return new int[]{startIndex,lastIndex};
        
    }

    public int getfirst(int[] nums, int target,int low, int high){
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid]== target){
                if(mid ==0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
                
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int target,int low, int high){
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid]== target){
                if(mid == nums.length-1 || nums[mid]!=nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }                
            }else if(nums[mid] > target){
                high = mid -1;
            }
        }
        return -1;
    }
    
}