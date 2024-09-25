// We will be using the prpoerty of the rotated sorted array that the minimum element would always lie in the unsorted part of the array. Based on this property we would be reducing the size of the array and performing the binary search.
// The time complexity would be O(logn) since we are using binary search.
// The space complexity would be O(1)
public class FindMinimum {
    
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int low=0, high = nums.length-1;
        while(low<=high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high-low)/2;
            if((mid ==0 || nums[mid]<nums[mid-1]) && (mid == high || nums[mid]<nums[mid+1])){
                return nums[mid];   
            }else if(nums[low]<=nums[mid]){
                low=mid+1;
                
            }
            else{
                high = mid-1;
            }
        
        }
        return -1;
        
    }
} 
