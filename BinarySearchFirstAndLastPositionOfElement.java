//Time Complexity:O(Log(2n))->O(Log(n))
//Space Complexity: O(1) -> Not using any auxiliary space
//Ran in Leetcode:Yes


//There is repetition of element and target is given
//Should find the indices of the first and last appearance of target
//Using binary search find the first position and then do binary search to find the last position

class BinarySearchFirstAndLastPositionOfElement {
    
    public int[] searchRange(int[] nums, int target)   
    {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarySearch(nums, target, false);
        int last = binarySearch(nums, target, true);
        return new int[]{first, last};

    }

    private static int binarySearch(int[] nums, int target, boolean last) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            //if target match the mid,check its first and last occurence
            if (nums[mid] == target) {
                //Checking the first occurence.
                if(!last) {
                    //Check if the current mid(that matched with target ) is greater than the previous immediate
                    if(mid ==0 || nums[mid] > nums[mid -1]){
                        //if yes return mid
                        return mid;
                    }
                        // if no ,shift right
                    else high = mid -1;
                }
                //Checking if the matched found is the last occurence
                else {
                        //if the current match less than the immediate next number
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                        //if yes,the current mid is the last occurence
                        return mid;
                    //else shift left
                    else low = mid +1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;

            }
        }

        return -1;
    }

}