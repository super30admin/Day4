package BinarySearch;

public class Problem1 {
	public static int[] searchRange(int[] nums, int target) {
        int left=extremeinsertionindex(nums,target,true);
        int right=extremeinsertionindex(nums,target,false)-1;
        
        int[] res= new int[]{-1,-1};
        if(left==nums.length || nums[left]!=target)
            return res;
        res[0]=left;
        res[1]=right;
        
        return res;
    }
    
    public static int extremeinsertionindex(int[] nums,int target,boolean left){
        int lo=0;
        int hi=nums.length;
        
        while(lo<hi){
            int mid= (lo+hi)/2;
            if(nums[mid]>target || (left && nums[mid]==target)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        
        return lo;
    }
    
    public static void main(String args[]) {
    	int[] nums=new int[] {2,3,4,5,6,6,6,7,7,7,8,9};
    	int target=6;
    	int[] res= searchRange(nums,target);
    	
    	System.out.println(res[0]);
    	System.out.println(res[1]);
    }
}
