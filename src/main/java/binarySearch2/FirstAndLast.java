package binarySearch2;

public class FirstAndLast {
	
	public static int left(int[] nums, int start,int end, int target){
        
	       
        while(start<=end){
        	
        int mid=start+(end-start)/2;
        
        if(mid==0&&nums[mid]==target) {return mid;}
       
        else if(nums[mid]==target) {
        	
        	if(nums[mid-1]==target) {
        		end=mid-1;
        	}else {return mid;}
        	
        }
        
        else if(nums[mid]<target) {
        	start=mid+1;
        }
        
        
        }
        return -1;
    
    }
    
     public static int right(int[] nums, int start,int end, int target){
        
        while(start<=end){
        
        int mid=start+(end-start)/2;
        
        if(mid==nums.length-1&&nums[mid]==target){return mid; }
        
        else if(nums[mid]>target){  end=mid-1;}
        
        else if(target==nums[mid]){
        	if(nums[mid+1]!=target) {return mid;}
        	      else { start=mid+1;  }
        
        
        }
            
            }
        return -1;
    
    }
    
    
    public static int[] searchRange(int[] nums, int target) {
       
        int start=0;
        int end=nums.length-1;
        
        int [] ar=new int[2];
        ar[0]=-1;
        ar[1]=-1;
    
        
        while(start<=end){
            
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
               
            	
                ar[0]=left(nums, start , mid, target);
                
                ar[1]=right(nums, mid, end, target);
               
                return ar;
           
            }
            
            else if(nums[mid]<target){
                           start=mid+1;
                     }else{
                
                end=mid-1;
            }
            
            
        }
        return ar;
        
    }

}
