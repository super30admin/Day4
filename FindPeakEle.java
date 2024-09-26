package BinarySearch1;

public class FindPeakEle {
	 public int findPeakElement(int[] nums) {
	        return search(nums,0,nums.length-1);
	        
	    }
	    public int search(int[] nums,int l,int r){
	        if(l==r) return l;
	        int mid= l+(r-l)/2;
	        System.out.println(mid);
	        if(nums[mid]>nums[mid+1]) return search(nums,l,mid);
	        return search(nums,mid+1,r);
	    }

}
