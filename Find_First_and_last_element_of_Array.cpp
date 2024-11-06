// for this particular problem we can perfrom the binary search for finding the first element 
// and we if find the first element we compare it with its previous element if it is not the 
// first index we can perfrom continue the binary search on left half
// once we have frist index we can perfrom the binary search on the right half starting from first index
// if we find the target we compare it with its next index if it is not the target we got our last index


class Solution {
    int BinarySearchFirst(int start, int end, int target,vector<int>& nums)
    {
        while(start<=end)
        {
            int mid = start + (end- start)/2;
            if(nums[mid]==target)
            {
                if(mid == 0 || nums[mid-1]!=target)
                    return mid;
                else
                    end = mid -1;
            }
            else if( target<=nums[mid])
                end = mid -1;
            else 
                start = mid +1;
        }
        return -1;
    }
    int BinarySearchSecond(int start, int end, int target,vector<int>& nums)
    {
        while(start<=end)
        {
            int mid = start + (end- start)/2;
            if(nums[mid]==target)
            {
                if(mid == end ||nums[mid+1]!=target)
                    return mid;
                else
                    start = mid +1;
            }
            else if(target <= nums[mid])
                end = mid -1;
            else 
                start = mid +1;
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0) return {-1,-1};
        int first = BinarySearchFirst(0, nums.size()-1,target,nums);
        if(first == -1)
            return {-1,-1};
        int second = BinarySearchSecond(first,nums.size()-1,target,nums);
        if(second == -1)
            return {first ,first};
        return{first,second};
    }   
};