// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class FindMinimum {
    public int findMin(int[] nums) {
        //1
       int low=0;
        int high=nums.length-1;
        //2
        while(low<high){
            int mid=low+(high-low)/2;
          
            //3
            //If the first element is less than the l;ast element then return the first element
            if(nums[low]<=nums[high])
                return nums[low];
            //4 
            //Find the pivot element by checking the mid element with the mid-1 element 
            if(mid>0 && nums[mid]<nums[mid-1])
                return nums[mid];
        
            else if(nums[mid]>=nums[low])
                low=mid+1;
            else 
            high=mid-1;
            
        }
        return nums[low];
    }

    public static void main(String args[]){
        FindMinimum obj=new FindMinimum();
        int []arr={3,4,5,1,2};
       int min= obj.findMin(arr);
       System.out.println("minimum element = "+min);

    }
}