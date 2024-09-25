
class Solution {
    public int findMin(int[] nums) {
        
        
            int low =0;
            int high = nums.length -1;
        
        
        while(low <= high){
            
            
            int mid = low  + (high-low)/2;   //To avoid integer overflow
            
            if(nums[low]< nums[high]) return nums[low]; //Array Already sorted
            
            //mid greater than its neighbours
            
            if ((mid == low || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid+1] )){
                return nums[mid];
            }
            
            //Check the sorted and move to the opposite side
            else if(nums[low] <=nums[mid]){ //left sorted , move right
                
                low = mid + 1;
            }
            
            else{
                
                high  = mid - 1; //Righ Sorted , move left
            }
                
            
            
            
        
        }
        return -1;
    }
}
//Time Complexity: O(Logn)
//Space Complexity: O(1)

