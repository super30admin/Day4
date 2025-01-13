class Solution {
    public int findMin(int[] nums) {

        int target = nums[nums.length-1];

        // base-case
        if (nums.length == 1){
            return target;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;


        while (low <= high){
            
            mid = (high - low)/2 + low;

            if (nums[mid] < target){
                // update the target to this new found lowest mid
                target = nums[mid];
                high = mid;
            }

            else{
                
                if (nums[low] < nums[mid] && target < nums[low]){
                    // lhs is sorted, search in rhs which is unsorted
                    low = mid + 1;
                }

                else{
                    // search in unsorted lhs aread as rhs is sorted
                    high = mid - 1;
                }

            }
            
        }
        
        // end of while loop

        return target;
    }
}