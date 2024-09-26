package BinarySearch1;

public class FirstAndLastEle {
	 public int[] searchRange(int[] nums, int targetsum) {
	        int[] result = new int[2];
	        result[0]=findLeftMostInteger(nums,targetsum);
	        result[1]=findRightMostInteger(nums,targetsum);
	        return result;
	       
	    }
	    public int findLeftMostInteger(int[] nums,int target){
	        int index=-1;
	        int left=0;
	        int right=nums.length-1;
	        while(left<=right){
	            int mid=(left+right)/2;
	            if(nums[mid]==target) index=mid;
	            if(nums[mid]>=target){
	                right=mid-1;
	            }
	            else{
	                left=mid+1;
	            }
	            
	        }
	        return index;
	        
	    }
	    
	    public int findRightMostInteger(int[] nums,int target){
	         int index=-1;
	        int left=0;
	        int right=nums.length-1;
	        while(left<=right){
	             int mid=(left+right)/2;
	             if(nums[mid]==target) index=mid;
	            if(nums[mid]<=target){
	                left =mid+1;
	                
	            }
	            else{
	                right=mid-1;
	            }
	            
	        }
	        
	         return index;
	    }

}
