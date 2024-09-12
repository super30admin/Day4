//Time Complexity: O(logn) -> First Occurence.
//                  O(logn) --> Last Occurence.
//Total time complexity: O(logn).
//Space Complexity: O(1).

//The if condition here plays a big role, so while solving this question make sure that if condition is properly framed. 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[] {-1, -1};
    
        
        if(target < nums[0] || target > nums[nums.length-1])
            return new int[] {-1, -1};
        
        int first = findFirstOccurence(nums, target);
        if(first == -1)
            return new int[] {-1, -1};
        
        int last = findLastOccurence(nums,target);
            return new int[] {first, last};
        
    }
    
    
    public int findFirstOccurence(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;

        while(low <= high){
             int mid = low + (high - low)/2;
             if(nums[mid] == target){
                 //check if it is first occurence by checking one more if condition. 
                 if(mid == 0 || nums[mid-1] < nums[mid]){
                     return mid;
                 }
                 else
                     high = mid - 1;
             }
            else if(target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;

    }
    
        public int findLastOccurence(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;
        while(low <= high){
             int mid = low + (high - low)/2;
             if(nums[mid] == target){
                 //check if it is first occurence by checking one more if condition. 
                 if(mid == nums.length-1 || nums[mid+1] > nums[mid]){
                     return mid;
                 }
                 else
                     low = mid + 1;
             }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = high - 1;
        }
            
    return -1; 
    
    }
}