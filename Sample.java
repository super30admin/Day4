//Finding the first and last indexes of an element.
//Time complexity - o(log(n))
//space complexity o(1)

// Using binary search, I will be finding the first index of the target and then after I will be finding the second index.
//For the first index, based on the target and mid element comparision, I will be switching the pointers. if mid element is
// equal to target, I will check for the left side of the mid is < than mid. if not, I will switch the high pointer to mid -1.
// Similarly for the second index, if mid == target, I will check the right element of the mid> mid. If not, I will the low pointer to mid +1
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res ={-1,-1};
        if(nums == null || nums.length==0)
            return res;
        if(target < nums[0] || target > nums[nums.length-1])
            return res;
        
        res[0] = binarySearchFirst(nums,target);
        res[1] = binarySearchLast(nums, target);
        return res;
    }
    
    private int binarySearchFirst(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid] > nums[mid-1])
                    return mid;
                else
                 high = mid-1;
            
            }
            else if(nums[mid]>target){
                high = mid -1;
            }
            else
                low =  mid + 1;
        }
        return -1;
    }
    
    private int binarySearchLast(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
        
            if(nums[mid]==target)
            {
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1])
                    return mid;
                else
                 low = mid+1;
            
            }
            else if(nums[mid]>target){
                high = mid -1;
            }
            else
                low =  mid + 1;
        }
        return -1;
    }
}

//Finding the min element in the rotated sorted array
//Time complexity is o(log(n))
//space complexity o(1)

// every time, I write algorithm in a manner that my search will be going on the side in which is array unsorted.
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums[0]<nums[nums.length-1])
            return nums[0];
        int low = 0, high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid+1]))
               return nums[mid];
            else if(nums[mid]>=nums[low] && nums[mid] > nums[high])
                    low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }
}

//Find Peak element
// Time complexity o(log(n))
// space complexity o(1)
//Every time, I will check the middle is greater than its neighbours. If not, I will switch the search towards the higher neighbour element.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(nums[mid+1]>nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return high;
    }
}