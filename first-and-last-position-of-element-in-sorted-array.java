//Time Complexity is O(logn)
//Space Complexity is O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result= new int [2];
        int i=0;
        //call the function to return first occurence of the number
        int firstIndex= findFirstIndex(nums, target);
        result[i++] = firstIndex;
        //call the function to return last occurence of the number
        int lastIndex= findLastIndex(nums, target);
        result[i] = lastIndex;
        
        return result;
    }
    
    public int findFirstIndex(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        
    while(low<=high){
        int mid = low + (high - low)/2;
        
        if(nums[mid] > target) high = mid -1;
        else if(nums [mid] < target) low = mid +1;
        else{ 
            if(mid == 0 || nums[mid - 1] != target) return mid;
            else high = mid - 1;
        }
    }
        return -1;
    }
    
    public int findLastIndex(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        
    while(low<=high){
        int mid = low + (high - low)/2;
        
        if(nums[mid] > target) high = mid -1;
        else if(nums [mid] < target) low = mid +1;
        else{ 
            if(mid == nums.length -1 || nums[mid + 1] != target) return mid;
            else low = mid + 1;
        }
    }
        
        return -1;
    }
    
}