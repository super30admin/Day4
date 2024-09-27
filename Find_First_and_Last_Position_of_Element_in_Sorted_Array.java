// time complexity: o(logn)
// space complexity: o(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int first = binarysearchfirst(nums, target);
        if(first == -1) return new int[] {-1, -1};
        int last = binarysearchlast(nums, target);

        return new int[]{first, last};
    }

    private int binarysearchfirst(int[] nums, int target){
        // to prevent integer overflow
        int low = 0;
        int high= nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                // check if it is a first occurance
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(target < nums[mid])
            {
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }

        return -1;

    }
    private int binarysearchlast(int[] nums, int target){
        int low = 0;
        int high= nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                // check if it is a last occurance
                if(mid == nums.length -1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid +1;

                }
            }
            else if(target < nums[mid])
            {
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }

        return -1;


    }

}