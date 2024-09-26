//PROBLEM - Find Minimum in Rotated Sorted Array(LC-153)
/** 3 Pointer Approcach: 
 * Fact Utlized :  Array was arranged in ascedning order and later rotated
 * Hence, the problem can be solved using Binary Search using N log time.
 * What we know for sure? 
 * 1. Array will always have atleast half part sorted
 * 2. The Min will always lie in the non-sorted part.
 * 3. For minimum item {other then First and Last item}, Left and right adjecent should be highher.
 * 4. Binary if Mid item is last or first, we left with 2 items and can directly compare.
 */ 
//
//time Complexity :
// LOG(N)

// Space Complexity :
//  O(1)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : Not sure about Space complexity should it be-
// O(LOG N) or O(1)


class Problem2 {
    public int findMin(int[] nums) {
     int start = 0;
     int end = nums.length - 1;
    
    if(start == end)
    return nums[0]; // if only 1 item return
     
      while(start<=end){
           
            int mid = start + (end - start) / 2; // find mid

            if(mid == 0 || mid == nums.length -1) // if mid is last or first, means only 2 items left.
                return Integer.min(nums[start], nums[end]);
            else if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]) // check if Its Minimum
                return nums[mid];
            else if(nums[mid]<nums[end]){ // if mid is lesser than last elemet then its SORTED array
                end = mid-1;  // number should be in unsorted array and hance move end to unsorted range
            }else {
                start = mid+1; // if above is sorted then left must be sorted array and move start to afte rmid
            }
            
        }

        return -1; // no element found
    }
}


//SOLUTION 2: 

/*
class Solution {
    public int findMin(int[] nums) {
     int start = 0;
     int end = nums.length - 1;
        
        while(start<=end){
           
            int mid = start + (end - start) / 2;
            
            if(mid==0){
                 if(nums.length==1)
                     return nums[mid];
                 return Integer.min(nums[0], nums[1]);
            }
            else if(mid == nums.length -1){
                return Integer.min(nums[nums.length-1], nums[nums.length-2]);
            }      
            else if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[mid]<nums[end]){
                end = mid-1;
            }else{
                start = mid+1;
            }
            
        }

        return -1;
    }
}


*/

//[7,6, 5, 4, 3, 2, 1, 8, 9]

//[]

// [0,1,2,4,5,6,7] -- 

// [2,4,5,6,7,0,1]

// [6,7,0,1,2,4,5]