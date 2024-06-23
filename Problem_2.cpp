// Approach
// 

#include <iostream>
#include <vector>

class Solution {
public:
    int findMin(std::vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        if (nums[high] > nums[low]) return nums[low];
        if (nums.size() == 1) return nums[0];

        while (low <= high){
            int mid = low + (high - low)/2;
            if (mid != 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            else if (mid != nums.size() - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            else if (nums[mid] >= nums[low]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
};


int main(){
    Solution sol = Solution();
    std::vector<int> matrix = {4, 5, 6, 7, 8, 2, 3};

    int result = sol.findMin(matrix);
    std::cout <<"Result output: "<< result << std::endl;

    return 0;
}