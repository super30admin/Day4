public class sample {
    //Find First and Last Position of Element in Sorted Array
//Time complexity : O(logm+logn)
//Space complexity : O(1)
//Did it run on leet code : Yes
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //set result as -1,-1
        int[] result = {-1, -1};
        
        int low = 0;
        int high = nums.length - 1;
        //find target's first occurance
        //update result
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] >= target){
                if(nums[mid] == target) result[0] = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //first element is changed in result means target exists
        //find second occurance or if its single element
        //update result
        if(result[0] > -1){
            low = 0;
            high = nums.length - 1;
            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid] <= target){
                    if(nums[mid] == target) result[1] = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        //return result
        return result;
    }
}

//Find Minimum in Rotated Sorted Array
//Time Complexity:O(logn)
//Space Complexity:O(1)
//Did it run on leet code : Yes
class Solution2 {
    public int findMin(int[] nums) {
        //if there array is not rotated or array has only one element
    if(nums[0]<nums[nums.length-1]||nums.length==1){
            return nums[0];
    }
        //comparing mid with first element change decrease high or increase low
        int low =0;
        int high =nums.length-1;
        while(low <= high){
            int mid = (low + high) /2;
            if(nums[mid]>=nums[0]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
      //return low
        return nums[low];
    }
}

// Find Peak Element
//Time complexity : O(logn)
//Space complexity : O(1)
//Did it run on leet code : Yes
//Time Complexity : O(logn)
//Space Complexity : O(1)
class Solution3 {
    public int findPeakElement(int[] nums) {

        int low=0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low+high) /2;
            //if the mid is greater than mid+1 
            //Assign high as mid
            //else increase low 
            if(nums[mid]>nums[mid+1]){
               high = mid;
            }
            else {
                low = mid +1;
            }
        }
        return low;
    }
}

}
