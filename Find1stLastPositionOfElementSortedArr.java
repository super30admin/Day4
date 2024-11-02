/*
Time Complexity:
O(log n): Both binarySearchFirst and binarySearchLast functions are O(log n) since they each perform binary search.
Overall: The algorithm has an overall time complexity of O(log n + log n) = O(2log n) = O(log n), making it efficient for large arrays.

Space Complexity
O(1): This solution only uses a fixed amount of space for variables, making the space complexity constant.

eg: 1,2,3,3,3,4,5,6,7,8,8
Element: 3
1st pos: 2
Last pos: 4
 */
class Find1stLastPositionOfElementSortedArr {
    public int[] searchRange(int[] nums, int target)
    {
        if(nums.length ==0) return new int[]{-1, -1}; //If no elements present, means target not found so return.

        /*
        We will be doing two binary search, one for finding the first index, and next for last index. For first index search, we will be searching the
        whole array, if first index is not found means target not present
        */

        int first = binarySearchFirst(nums, target, 0, nums.length-1);
        if(first == -1)
            return new int[]{-1, -1};

        int last = binarySearchLast(nums, target, first, nums.length-1);
        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            //If mid is the target
            if(nums[mid]==target) //we found the element, but not the first index
            {
                if(mid==0 || nums[mid-1] != nums[mid]) //IF mid = 0 means it is the first index so mid-1 won't exist
                {
                    return mid; //first index is the middle element
                }
                else {
                    high = mid-1; //So we move the pointer to left to find the start of the element which is first index
                }
            }
            else if(nums[mid]>target)
            {
                //Sorted array so search the left part of the array
                high = mid-1;
            }
            else {
                //Searching the right part of the arrray
                low = mid+1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            //If mid is the target
            if(nums[mid]==target) //we found the element, but not the first index
            {
                if(mid==nums.length-1 || nums[mid] != nums[mid+1]) //IF mid = n-1 means it is the last index so mid+1 won't exist
                {
                    return mid; //last index is the middle element
                }
                else {
                    low = mid+1; //So we move the pointer to right to find the last index of the element
                }
            }
            else if(nums[mid]>target)
            {
                //Sorted array so search the left part of the array
                high = mid-1;
            }
            else {
                //Searching the right part of the arrray
                low = mid+1;
            }
        }

        return -1;
    }
}