package mediumProblems;

public class Find_min_in_rotated_sorted_array {
	
    public int findMin(int[] nums) {
        
        
        if(nums.length ==0 || nums == null)
            return -1;
        
        //if there is only one element present
        if(nums.length ==1)
            return nums[0];
        
        int low=0;
        int high = nums.length -1;
        
        //if the array is already sorted
        if(nums[0] < nums[high])
            return nums[0];
        
        while(low<=high)
        {
            int mid = low + (high -low)/2;
            
            //see the pivot near mid
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            
            //min is always gonna present in the unsorted array
            if(nums[low] < nums[mid])
                low = mid +1;
            else
                high = mid -1;
        }
        
        return -1;
        
    }

	public static void main(String[] args) {
		
		Find_min_in_rotated_sorted_array obj = new Find_min_in_rotated_sorted_array();
		int[] nums = {5,1,2,3,4};
		System.out.println(obj.findMin(nums));

	}

}
