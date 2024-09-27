/*
Time complexity -->
O(logn)

Space Complexity
O(1)

Approach -->
Chcek if the array is of length 1 if so return 0
Use binary Seach approach 
get the mid value and check if left of the mid is greater or right of mid is greater
Go to the higher value side and perform binary search algorithm 
At one point we reach the peak 
return the index of that element
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int n = nums.length-1;
        int mid = 0;
        if(l==h){
            return 0;
        }
        else{ // Binary Search 
            while(l<=h){
            mid = (l+h)/2;
            if((mid!=0) && (nums[mid-1]>nums[mid])){ // if higer value is towards left
                h = mid-1;
            }
            else if((mid!=n) && (nums[mid+1]>nums[mid])){ // if higher value is towards right
                l = mid+1;
            }
            else{
                return mid;
            }
           
            }//while
        
        }//else
        
     return mid;   
        
    }
}