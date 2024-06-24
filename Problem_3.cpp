// Approach
// Following the Mihir baba's approach to always move towards the top and
// surely we will reach the peak

#include <iostream>
#include <vector>

class Solution {
public:
    int findPeakElement(std::vector<int>& nums) {
        int low = 0;
        int size = nums.size();
        int high = size - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (mid != size -1 && nums[mid + 1] > nums[mid]) low = mid + 1;
            else if (mid != 0 && nums[mid - 1] > nums[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }
};


int main(){
    Solution sol = Solution();
    std::vector<int> matrix = {4, 5, 6, 7, 8, 2, 3};

    int result = sol.findPeakElement(matrix);
    std::cout <<"Result output: "<< result << std::endl;

    return 0;
}