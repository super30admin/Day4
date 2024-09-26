//Recursively using binary search to find out the peak element in an array. The find peak element function will call the peak function which will in turn recursively find out the peak element by comparing the left and the right element and return them if they are equal, else will compute mid element and follow a recursive pattern until the left element is equal to the right, which will give an indication that it is a peak element. Time complexity: O(logN) and space complexity: O(logN). 
//This code passed all test cases in leetcode as well as the sample test case provided in the main function. 

class Solution {

    public static void main(String[] args){
        Solution s=new Solution();
        int nums[]={1,2,1,3,5,6,4};
        int peak= s.findPeakElement(nums);
        System.out.println("the peak is: "+peak);
    }
    
    public int findPeakElement(int[] nums) {
        
       return peak(nums,0,nums.length - 1);
        
    }
    private int peak(int[] nums,int l,int r){
        if(l==r){
            return l;
        }
        int mid=(l+r)/2;
        if(nums[mid]>nums[mid+1]){
            return peak(nums,l,mid);
        }
        else{
            return peak(nums, mid+1,r);
        }
    }
   
}
