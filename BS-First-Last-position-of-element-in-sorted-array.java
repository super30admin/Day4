//Time Complexity: O(Logn)
//Space Complexity: O(1)


//2 Different binary search functions to find both indexes

class Solution {
    
    
    private int first(int nums[],int target){
        
        int low = 0;
        int high = nums.length-1;
        
        while (low<=high){
            
            int mid = low + (high-low)/2;
            
            
            //case 1
            
            if(nums[mid] == target){
                
                if (mid == low || nums[mid-1] < nums[mid])
                    return mid;
                else
                    high = mid -1;
            }
            
            
            //case 2
            
            else if(nums[mid]>target){
                high = mid -1;
            }
            
            //case 3
            
            else 
                low = mid + 1;
        }
        
        return -1;
        
        
    }
    
     private int second(int nums[],int target){
         
        int low = 0;
        int high = nums.length-1;
         
         
        
        while (low<=high){
            
            int mid = low + (high-low)/2;
            
            //case 1
            
            if(nums[mid] == target){
                
                if (mid == high || nums[mid+1] > nums[mid])
                    return mid;
                else
                    low = mid + 1;
            }
            
            
            //case 2
            
            else if(nums[mid]>target){
                high = mid -1;
            }
            
            //case 3
            
            else 
                low = mid + 1;
        }
        
        return -1;
        
        
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        
        int first_index = first(nums,target);
        int second_index = second(nums,target);
        
        return new int[] {first_index,second_index};
        
        
        
        
        
    }
}