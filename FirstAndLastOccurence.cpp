#include <bits/stdc++.h>

using namespace std;

vector<int> searchRange(vector<int>& nums, int target)
{
    int low = 0, high = nums.size() - 1, mid;
    vector<int> res {-1, -1};

    while (low <= high) {
        mid = (low + (high - low) / 2);
        if ((target == nums[mid]) && ((mid == low) || (target > nums[mid - 1]))) {
            res[0] = mid;
            break;
        }
                
        if (target <= nums[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    if (res[0] == -1) {
        return res;
    }
        
    low = res[0];
    high = nums.size() - 1;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        if ((target == nums[mid]) && ((mid == high) || (target < nums[mid + 1]))) {
            res[1] = mid;
            break;
        }
                
        if (target >= nums[mid]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
                
    return res;
}

int main ()
{
    vector<int> nums = {1,3,4,5,5,5,8,9};
    vector<int> res;

    res = searchRange(nums, 5);
    cout << "5 is at [" << res[0] << "," << res[1] << "]" << endl;

    return 0; 
}
