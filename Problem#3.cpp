
// Find preak element  ##Problem3

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int l =0;
        int r = nums.size()-1;
        
        while (l<r)
        {
            int mid = (l+r)/2;
            
            if (nums[mid] > nums [mid+1])
                
                r = mid;
            else 
                l = mid+1;
        }
       
        return l;
    }
};


/*
Compelxity Analysis:

Time Complexity: O(Logn).
Where n is the number of elements in the input array. In each step our search becomes half. So it can be compared to Binary search, So the time complexity is O(log n)
Space complexity: O(1).
No extra space is required, so the space complexity is constant.
*/
 
