class Solution:
    """
        Updated as per discussion in class
        // Time Complexity :
                            O(logn) 'n' is the number of elements in the list
        // Space Complexity :
                            O(1) Constant
        // Did this code successfully run on Leetcode :
                            Yes
    """
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        if not nums:
            return -1
        while low <= high:
            mid = (low + high) // 2
            # perfectly sorted
            if nums[low] < nums[high]:
                return nums[low]
            # base case and edge case
            if ((mid == len(nums) - 1 or nums[mid] < nums[mid + 1]) and
                    (mid == 0 or nums[mid] < nums[mid - 1])):
                return nums[mid]
            # right is sorted, go to left
            elif nums[mid] < nums[high]:
                high = mid - 1
            # left is sorted, go to right
            else:
                low = mid + 1
        # """
        # // Time Complexity :
        #                     O(logn) 'n' is the number of elements in the list
        # // Space Complexity :
        #                     O(1) Constant
        # // Did this code successfully run on Leetcode :
        #                     Yes
        # // Any problem you faced while coding this :
        #                    Took a lot of time to understand the difference between
        #                    searching for a target in rotated sorted v/s this problem.
        # // Your code here along with comments explaining the approach
        #     We do a simple binary search. The interesting thing about the problem
        #     is we will can completely omit one half after comparing the start end end
        #     values. The reason being this a sorted in a rotated manner with unique numbers.
        #     If the last element is greater than the current mid then all number after that
        #     are greater than the current mid. We donot need to search after mid and vice versa.
        # """
        # start = 0
        # end = len(nums) - 1
        # while start < end:
        #     mid = (start + end) // 2
        #     if nums[end] < nums[mid]:  # mid > end
        #         start = mid + 1
        #     else:
        #         # start < mid or mid > start
        #         end = mid
        # return nums[start]


if __name__ == '__main__':
    h = Solution()
    # Sample test case for '''end = mid - 1 '''
    # print(h.findMin([3, 0, 2]))
    print(h.findMin([2, 1]))
