/**Time Complexity :
    O(log n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
// Your code here along with comments explaining your approach
**/


class firstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {

        //edge cases
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        if(target<nums[0] || target>nums[nums.length-1]) return new int[]{-1,-1};

        //to get first position
        int first=binarySearchFirstOccurence(nums,target);
        if(first==-1) return new int[] {-1,-1};

        //to get last position
        int last =binarySearchLastOccurence(nums,target);
        return new int[] {first,last};
    }


    private int binarySearchFirstOccurence(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
       
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){

                //check if element before mid is the target or not, not return 
                if(mid==0 || nums[mid-1]<nums[mid]){
                return mid;
              }
              //if previous elemnt is target then decrease high
               else{
                    high=mid-1;
                }
            } 

            //adjust pointer if target is less than mid
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }


     private int binarySearchLastOccurence(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){

                //check for the last occurence of element, by checking next element is greater than mid
                if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                return mid;
              }
               else{
                   low=mid+1;
                    
                }
            }

            //adjust pointer if target is less than mid 
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}