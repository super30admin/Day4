package BinarySearch;

/*
  Time complexity : o(log n)
  Space complexity : o(n)
  Did this code run succesfully in leetcode : yes
  problems faces : no
  Apply binary search .minimum will be present in the unsorted side of the array.
  for every pivot identified check if the adjacent elements are grater than the element at pivot.
  if yes then that pivot element is the minimum
*/ 
public class SearchMinimumInRotatedSortedArray {
    
 public int findMin(int[] nums) {
     
     
     if(nums== null || nums.length ==0) return -1;
     int left = 0;
     int right = nums.length-1;
     int pivotIndex =-1 ;
     
     while(left<=right)
     {
         if(nums[left] < nums[right])
         {
             return nums[left];
         }
         pivotIndex = left +( right-left)/2;
         if((pivotIndex==0 || nums[pivotIndex] < nums[pivotIndex-1]) && 
              (pivotIndex==nums.length-1 || nums[pivotIndex] < nums[pivotIndex+1]) )
         {
             return nums[pivotIndex];
         }
         else if(nums[left] <= nums[pivotIndex] ) //always check if left is sorted first
         {
             left = pivotIndex+1;
            
         }
          else
         {
             right = pivotIndex-1;
         }
         
         
     }
     return nums[pivotIndex];
 
 }

}
