
//Time Complexity:O(Log(2n))->O(Log(n))
//Space Complexity: O(1) -> Not using any auxiliary space
// Did this code successfully run on Leetcode :Yes



//Using Binary search to return one of the peak element
//If last element is bigger,have to consider that as peak ,since the range given -1 to Infinity given
//Check the immediate left and right of the mid and set the direction to move on.
//if the immediate member to the left of mid is greater,then shift high to mid-1 and continue until peak is found and return.In this apprach even if there is a peak to the right we dont have to worry as the question is to return one peak
//if the immediate member to the right of the mid is grater ,then shift low to mid+1 and journey continue to right until the peak is found.In this case we are ignoring the left even if there is peak to the left subarray.The question is to return just one peak element
class BinarySearchToFindOneOfPeekElement {
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length-1;

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            //To find peak
            if((mid == 0 || nums[mid] > nums[mid-1]) && ( mid == nums.length-1 || nums[mid] >nums[mid+1])){
                return mid;
            }
            else if(nums[mid] < nums[mid-1])
            {
                high = mid-1;
            }
            else
                low = mid +1;
        }

        return -1;
    }
