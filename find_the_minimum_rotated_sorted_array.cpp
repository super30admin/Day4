class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0;
        int end = nums.size() -1;
        //base case
        if(nums.size()==1)
            return nums[0];
        if(nums[start] < nums[end])
            return nums[start];

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid +1])
                return nums[mid+1];
            if(nums[mid- 1] > nums[mid] )
                return nums[mid];
            else if (nums[mid] > nums[start])
                start = mid +1;
            else
                end = mid -1;
        }
        return -1;
    }
};

