
public class FindFirstandLastPositionofElementinSortedArray {
	
	
    public int[] searchRange(int[] nums, int target) {
        
        
        int first= getFirstBinarySearch(nums,target);
     
             
        int second= getSecondtBinarySearch(nums,target);
        
        
        System.out.println(first + ""+ second);
        
        return first==-1 ? new int[]{-1,-1}: new int[]{first,second};
        

        
    }
    
    
  public int  getFirstBinarySearch(int[] nums, int target){
      
      
      int low=0;
      int high= nums.length-1;
      
      while(low<=high){
          
          int mid= low + (high-low)/2;
          
          if(nums[mid]==target){
              
              if(mid==0 ||  nums[mid] > nums[mid-1]){
                  return mid;
              }
              else{

                  high= mid-1;

              }
          
              
          }else if(nums[mid]>target){
              high= mid-1;
          }
          
          else{
              low=mid+1;
          }
          
      }
      
      return -1;
      
      
  }
    
    
    
    
    public int  getSecondtBinarySearch(int[] nums, int target){
      
      
      int low=0;
      int high= nums.length-1;
      
      while(low<=high){
          
          int mid= low + (high-low)/2;
          
          if(nums[mid]==target){
              
              if(mid==nums.length-1 ||  nums[mid] < nums[mid+1]){
                  return mid;
              }
              else{

                  low= mid+1;

              }
          
              
          }else if(nums[mid]<target){
              low= mid+1;
          }
          
          else{
              high=mid-1;
          }
          
      }
      
      return -1;
      
      
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindFirstandLastPositionofElementinSortedArray objIn= new FindFirstandLastPositionofElementinSortedArray();
		
		int[] nums= {5,7,7,8,8,10};
		
		System.out.println(objIn.searchRange(nums, 8));


	}

}
