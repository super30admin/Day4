// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class findRange {
    public int[] searchRange(int[] nums, int target) {
       return helperBinarySearch(nums,0,nums.length-1, target);
    }

    /*
      Followed approach of first finding the target element and
    then finding it's left and upper bound. The lement is searched using
    binary search and similarly left and right are found using binary search
    */
    public int[] helperBinarySearch(int[] nums, int low, int high, int target){

        int mid;

       int[] ret = {-1,-1};

        while(low <= high){

            mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                ret[0] = findLeft(nums, low, mid, target);
                ret[1] = findRight(nums,mid,high,target);
                break;
            }

            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }

        return ret;

    }


    public int findLeft(int[] nums, int low, int high, int target){
        if(low == high) return low;

        int mid = low + (high - low)/2;

        if(nums[mid] != target && nums[mid+1] == target) return mid + 1;

        else if(nums[mid] >= target){
            return findLeft(nums, low, mid,target);
        }

        else{
            return findLeft(nums,mid+1, high, target);
        }
    }

    public int findRight(int[] nums, int low, int high, int target){
        if(low == high) return low;

        int mid = low + (high - low)/2;

        if(nums[mid] == target && nums[mid+1] != target) return mid;

        else if(nums[mid] > target){
            return findRight(nums, low, mid-1,target);
        }

        else{
            return findRight(nums,mid+1, high,target);
        }
    }
}
