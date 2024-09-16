/**Time Complexity: O(log n)
 * Space Complexity: O(1)**/
class MinRotatedArray {
	public int findMin(int[] nums) {
        //If only one element in array, then its the smallest.
        //If last element is greater than first, means its not rotated and first is smallest
        if(nums.length ==1 || nums[nums.length-1] > nums[0]){
            return nums[0];
        }
                
        int low=0;
        int high=nums.length-1;
        
        while(low <= high){
            int mid= low + (high-low)/2;
            
            //if mid element is greater than its right, means its the end of rotation and next element is smallest
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            
            //If mid is less than its left, means its the smallest
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }                        
            
            //Left sorted, search in right
            if(nums[mid] > nums[0]){
                low=mid+1;
            }else{ //Right sorted, search in left
                high=mid-1;
            }     
        }
        
        return -1;
    }
    
    
    // Driver code to test above 
    public static void main(String args[]) 
    { 
    	MinRotatedArray ob = new MinRotatedArray(); 
    	int[] nums = {3,4,5,1,2};
        System.out.println("Min element in rotated array is: "+ob.findMin(nums));
    } 
}
