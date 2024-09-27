#include <bits/stdc++.h>

using namespace std;

int findPeakElement(vector<int>& nums)
{
    int low = 0, high = nums.size() - 1, mid;
    while (low <= high) {
        mid = (low + (high - low) / 2);
        if (((mid == high) || (nums[mid] > nums[mid + 1])) && 
            ((mid == low) || (nums[mid] > nums[mid - 1]))) {
                break;
        }

        if ((nums[mid] < nums[mid + 1])) {
            low = mid + 1;
        } else {
            high  = mid - 1;
        }
    }
        
    return mid;
}

int main ()
{
    vector<int> nums1 = {3,2,3,4};
    cout << "Peak is at " << findPeakElement(nums1) << endl;
    vector<int> nums2 = {1,2,1,0,1,5,3,1};
    cout << "Peak is at " << findPeakElement(nums2) << endl;

    return 0;
}
