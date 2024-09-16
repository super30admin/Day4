class FirstAndLastSolution{
    //Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I first thought of finding out target index and then expand
    //                                        the scope to left and right and find out the first and last undex
    //                                          but that approach gave 75/88 test cases pass and there were many modifications

    //below approach uses binary search but we need to think about the directions of search.

    public int[] searchRange(int[] nums, int target) {
        //find first position
        int first = binarySearchFirst(nums,target);
        //if we dont get the element itself then no need to proceed any further
        if (first == -1) return new int[]{-1,-1};
        //go to the last direction
        int last = binarySearchLast(nums,target);

        return new int[]{first,last};
    }

    private int binarySearchFirst(int[] nums,int target){
        int left = 0, right = nums.length-1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            //here we know that if we find the element in first search, then just store the index and move to left direction
            //the right pointer will help us find first element.
            //that why we have left <= right in while condition.
            //other reason of using left <= right is for single element use case.
            if (nums[mid] >= target){
                if (nums[mid] == target){
                    index = mid;
                }
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return index;
    }
//similarly we will be moving to last element using left pointer.
    private int binarySearchLast(int[] nums,int target){
        int left = 0, right = nums.length-1;
        int index = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] <= target){
                if (nums[mid] == target){
                    index = mid;
                }
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return index;
    }

}

/*
leetcode status:
88 / 88 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 42.4 MB
 */