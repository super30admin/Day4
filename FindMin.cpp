#include <bits/stdc++.h>

using namespace std;

int findMin(vector<int>& nums)
{
    int low = 0, high = nums.size() - 1, mid;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        if (((mid == high) ||(nums[mid] < nums[mid + 1]) &&
            ((mid == low) || (nums[mid] < nums[mid - 1])))) {
            break;
        }
            
        if (nums[mid] > nums[high]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    return nums[mid];
}

int main ()
{
    vector<int> nums = {2,4,5,7,9,0};
    cout << "Min is " << findMin(nums) << endl;

    return 0;
}
