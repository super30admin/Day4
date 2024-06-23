// Approach
// 

#include <iostream>
#include <vector>

class Solution {
public:
    int find_element(std::vector<int>& nums, int target, bool first) {
        int size = nums.size();
        if (first) {
            if (nums[0] == target)
                return 0;
        } else {
            if (nums[size - 1] == target)
                return size - 1;
        }
        int l = 0;
        int h = size - 1;
        int idx = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                h = mid - 1;
            else {
                idx = mid;
                if (first == true)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return idx;
    }

    std::vector<int> searchRange(std::vector<int>& nums, int target) {
        int starting = -1;
        int end = -1;
        if (nums.size() > 0) {
            starting = find_element(nums, target, true);
            if (starting != -1)
                end = find_element(nums, target, false);
        }
        return {starting, end};
    }
};

int main(){
    Solution sol = Solution();
    int rows = 7;
    std::vector<int> matrix = {4, 5, 6, 6, 6, 2, 3};

    std::vector<int> result = sol.searchRange(matrix, 6);
    std::cout <<"True  Result case output: ["<< result[0] << "," << result[1] << "]" << std::endl;

    result = sol.searchRange(matrix, 400);
    std::cout <<"False Result case output: ["<< result[0] << "," << result[1] << "]" << std::endl;
    return 0;
}