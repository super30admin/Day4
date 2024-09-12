// Find minimum in rotated sorted array

//Pivot will always lie in the unsorted side

// if we have a totally sorted array, we return the low index

// in case of skewed rotated array - the min has to be in the hald which isnt sorted, and it will be after the largest element
// in case of a rotation such that both halves are sorted, we need to check which half is the smaller one
    
//first try to locate which half is sorted

class Solution {
    public int findMin(int[] nums) {
    
    int low = 0;
    int high= nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if ((mid==0 || nums[mid]<=nums[mid-1]) && 
                (mid ==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            
            else if (nums[low]<=nums[mid]){ //check if low is sorted
                low = mid+1;
                
            }else{
                high = mid-1;
            }
        }
   
    return 121221212;   
        
    }
}