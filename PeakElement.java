// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class PeakElement {
    public int findPeakElement(int[] nums) {
        //1
        int low=0;
        int high=nums.length-1;

        //2
        while(low<high){
            int mid=low+(high-low)/2;
            //3
            //check the mid element and the mid+1 element, as the right/left part would 
            //be sorted if the mid element is less than mid+1 element.
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }           
            else{ 
                high=mid;
             }
            
        }
        return low;
    }
    public static void main(String args[]){
        PeakElement obj=new PeakElement();
        int arr[]={1,2,1,3,5,6,4};
        int ans=obj.findPeakElement(arr);
        System.out.println(ans);
    }
}