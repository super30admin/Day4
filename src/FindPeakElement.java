
public class FindPeakElement {
	
    public int findPeakElement(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            
            int mid= low+ (high-low)/2;
            
            if((mid==0 || nums[mid]> nums[mid-1]) &&( mid== nums.length-1 ||nums[mid]>= nums[mid+1] )){
                return mid;
            }
            else if( nums[mid+1]> nums[mid]){
                low= mid+1;
            }else{
                high= mid-1;
            }
        }
        
        return -1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindPeakElement objIn= new FindPeakElement();
		
		int[] nums= {1,2,3,1};
		
		System.out.println(objIn.findPeakElement(nums));

	}

}
