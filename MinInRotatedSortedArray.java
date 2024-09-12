
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0)
        {
            return Integer.MAX_VALUE;
        }
        
        //Binary Search
        int low = 0, high = nums.length-1;
        
        while(low <= high){

                //check if array already sorted
                //Case: When we move to unsorted part but there eventually sub array could be sorted and    we may miss the min from the left side and move to right
                if(nums[low] <= nums[high]){
                    return nums[low];
                }

                //Find mid
                int mid = low + (high - low)/2;

                //check if [mid-1] and [mid+1] are greater than [mid] --> then [mid] is min
                if((mid == low || nums[mid-1] > nums[mid]) &&
                   (mid == high || nums[mid+1] > nums[mid])){

                       return nums[mid];
                }

                //Decide where to move? Left or right
                if(nums[low] <= nums[mid]){
                    low = mid + 1;  // Left part is sorted, go right  
                }
                else{
                    high = mid - 1;  // Right part is sorted, go left
                }
            }
                   
            return Integer.MAX_VALUE;
        }            
    }