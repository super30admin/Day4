// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class FirstLast {
     
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[]{-1,-1};
        //1 
        // Define method to find first and the last occurence of the target element
        findFirst(nums,target,result);
        findLast(nums,target,result);    
        return result;
        
    }
    
    //2 
    //Method to find the first occurence
    private void findFirst(int[] nums,int target,int []result){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            
            int mid=(low+high)/2;
            //3 
            //When target is equal to mid value we shift the high pointer
            if(target==nums[mid])
            {         
               result[0]=mid;
                high=mid-1;
                
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else low=mid+1;
            
        }
    }
    
    private void findLast(int[] nums,int target,int []result){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            
            int mid=(low+high)/2;
            //4
            //When target is equal to mid value we shift the low pointer
            if(target==nums[mid])
            {         
                result[1]=mid;
                low=mid+1;
                
                
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else low=mid+1;
            
        }
    }
    
    public static void main(String args[]){
        FirstLast obj=new FirstLast();

       int []nums={5,7,7,8,8,10};
       int target = 8;

       int []result= obj.searchRange(nums,target);
    
       System.out.println("Interval: ");
       for(int i=0;i<result.length;i++)
       System.out.print(result[i]+" ");



    }
}