package Strings;

class FindPeak {
	/**Time O(log n) | Space O(1)**/
	public int findPeakElement(int[] nums) {       
        int low=0;
        int high=nums.length-1;
        
        while(low < high){
            int mid= low + (high-low)/2;
            
            if(nums[mid] > nums[mid+1]){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    
    // Driver code to test above 
    public static void main(String args[]) 
    { 
    	FindPeak ob = new FindPeak(); 
    	int[] nums = {3,4,5,1,2};
        System.out.println("Index of peak element in rotated array is: "+ob.findPeakElement(nums));
    }
}
