/**Time Complexity: O(log n)
 * Space Complexity: O(1)**/
class BinarySearchRange { 	
	public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        
        int firstIndex= findIndex(nums, target, true);        
        if(firstIndex == -1){
            return new int[] {-1,-1};
        }
        
        int lastIndex= findIndex(nums, target, false);
        
        return new int[]{firstIndex, lastIndex};        
    }
	
    //Perform Binary search to find index
    private int findIndex(int[] nums, int target, boolean isFirst){
        int low=0;
        int high=nums.length-1;        
        
        while(low <= high){
            int mid= low + (high-low)/2;
            
            if(target == nums[mid]){       
                if(isFirst){
                    if(low == mid || nums[mid-1]!=target){
                        return mid;
                    }    
                    //search left;
                    high= mid-1; 
                }else{
                    if(high == mid || nums[mid+1]!=target){
                        return mid;
                    }
                    //search right
                    low=mid+1;
                }              
            }else if(target > nums[mid]){
                low= mid+1;
            }else{
                high= mid-1;
            }
        }
        
        return -1;
    }
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
    	Solution ob = new Solution(); 
    	int[] nums = {5,7,7,8,8,10};
    	int target = 8 ;
        System.out.println("Start and end position of "+target+" is "+ Arrays.toString(ob.searchRange(nums, target)));
    } 
} 
