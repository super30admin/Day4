package binarySearch2;

public class FindMin {
	
public int findMin(int[] nums) {
        
        
        int l=nums.length;
        
        if(l==1){return nums[0];}
        int start =0;
        int end=nums.length-1;
        
        
        
        while(start<=end){
        
        
            
        int mid=start+(end-start)/2;
       
        
if(nums[(mid-1+l)%l]>nums[mid] && nums[(mid+1+l)%l]>nums[mid])

{return nums[mid];}
          
            if(nums[mid]>nums[end]){
            //right is sorted
            
            start=mid+1;
            
            
        }   else{
            //right is sorted;
                
                end=mid-1;
            
        } 
            
        }
     return -1;   
    }

}
