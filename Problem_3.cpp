class Solution
{
public:
    int findPeakElement(vector<int> &nums)
    {

        if (nums.empty())
        {
            return -1;
        }

        int n = nums.size();
        int low = 0;
        int high = n - 1;

        // Binary Search
        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // Check if mid is the peak by checking with neighbors
            // Check if the mid has reached the beginning of the array and check if satisfies the peak condition
            // Check if the mid has reached the end of the array and and check if satisfies the peak condition
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                (mid == n - 1 || nums[mid] > nums[mid + 1]))
            {
                return mid;
            }

            // Move low
            else if (nums[mid + 1] > nums[mid])
            {
                low = mid + 1;
            }

            // Move high
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
};