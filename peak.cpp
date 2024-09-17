//TC: O(log n), where n is no. of elements
//SC: O(1)

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int l = 0;
        int r = nums.size()-1;
        
        while(l<r){
            
            int mid = l+ (r-l)/2;
            
            //if middle element is greater than the element to its right, then the peak will lie somewhere to it's left for sure 
            if(nums[mid] > nums[mid+1])
                r = mid;
            //else peak will lie somewhere to the right 
            else 
                l = mid + 1; 
        }
        
        //when l == r then break. return l or r.
        return r;
            
    }
};