# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : index out of bounds due to not all conditions covered in base case. the two base conditions were difficult to think through
public class Solution {
    public int findMin(int[] num) {
        //base cases 
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        
        //binary search here :
        //there are two conditons to check first for minimum. Compare the mid value by the previous value. if it is less than mid is min. 2) compare with the next element if it is greater than mid+1 is min
        int start = 0, end = num.length - 1;
        if(num[end]>num[start])
        {return num[0];}
        while (start < end ) {
            int mid = (start + end) / 2;
            if ( mid> 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if(num[mid]>num[mid+1])
            {   return num[mid+1];}
        
            //the minimum lies in the left half
            if (num[start] <= num[mid] ) {
                start = mid + 1;
            } else {
                end = mid - 1; //right half
            }
        }
    return -1;
    }}
