package mediumProblems;

public class First_Last_Index_of_Element {
	
    public int[] searchRange(int[] nums, int target) {
     	
    	
        //Edge case:
        if(nums == null || nums.length ==0)
            return new int[] {-1,-1};
        
        //Have a seperate binary function for first and last index
        int first = firstpos(nums, target);
        int last = lastpos(nums, target);
        	
        	
       return new int[] {first, last};
        
    }
    
    public int firstpos(int[] nums, int target){
    	
    	 int low =0;
         int high= nums.length -1;
        
        while(low <=high)
        {
            int mid = low +(high - low)/2;
            if(nums[mid] == target)
            {
            	//if mid is the left most element? 
            	if(mid ==0 || nums[mid-1] < nums[mid])
            		return mid;
            	else// that means there are duplicates and need to move to left for the first occurrence
            		high = mid -1; //keep moving left
            }else if(target > nums[mid]){
            	low = mid + 1;
            }else {
            	 high = mid - 1;
            }
                
        }
        return -1;
    }
    
    
    public int lastpos(int[] nums, int target){
    	
    	 int low =0;
         int high= nums.length -1;
        
        while(low <=high)
        {
            int mid = low +(high - low)/2;
            if(nums[mid] == target)
            {
            	//if mid is the right most element
            	if(mid == nums.length-1 || nums[mid+1] > nums[mid])
            		return mid;
            	else//that means there are duplicates and need to move to right for last index
            		low = mid + 1; //keep moving right
            	
            }
            else if(target > nums[mid])
                	low = mid + 1;
            	else
            		high = mid - 1;
                
        }
        return -1;
    }
    
	

	public static void main(String[] args) {
		
		First_Last_Index_of_Element obj = new First_Last_Index_of_Element();
		int[] nums = {5,7,7,8,8,8,8,10};
		int[] test1 = obj.searchRange(nums, 8);
		for(int n : test1) {
			System.out.println(n);
		}

	}

}
