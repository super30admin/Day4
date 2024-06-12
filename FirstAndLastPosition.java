/*package whatever //do not write package name here */
// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int[] searchRange(int[] nums, int target) 
    {   //taking variables to store result array and index
        int ind=0;
        int[] arr=new int[2];
        //assign values for exceptional cases
        arr[0]=-1;
        arr[1]=-1;
        //if array is empty,return exceptional value
        if(nums.length==0)
        {
            return arr;
        }
        //searching for the target in array
        while(nums[ind]!=target)
        {   //if element doesn't exists at all
            if(ind==nums.length-1 && nums[ind]!=target)
            {  
                return arr;
            }
            //incrementing the index
            ind+=1;
        }
        //taking counter to count the number of times the value repeats in array
        int counter=0;
        //temp to store prev value of index
        int temp= ind;
        //to remove index out of bound exception
        while(ind+1<=nums.length-1 && nums[ind]==nums[ind+1] )
        {
            counter+=1;
            ind+=1;
        }
        //returning the required value
        arr[0]=temp;
        arr[1]=temp+counter;
        return arr;
    }
}