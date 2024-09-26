'''
Solution 1:
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
Explanation: Brute Force Approach check if current element > Next element, if yes then return the element previous to peak index
if not the peak index will be the last element, assuming the array is somewhat sorted. Here we return the first peak element

Solution 2:
Time Complexity : O(log N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : I tested to check if elements are sorted and then thought of bianry search ( Should
have realised earlier) To effectively use binary search for this problem but it was actually very easy.
Explanation:
Here we check if the mid element > right element, if it is true then find the peak on the right using binary search
if not find the peak on the left side using binary search.
'''
class Solution:
    def linearFindPeakElement(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 0
        for i in range(0, len(nums) - 1):
            if nums[i] > nums[i + 1]:
                return i
        return len(nums) - 1

    def binarySearch(self, nums: List[int], low: int, high: int) -> int:
        if high == low:
            return low

        mid = int(low + (high - low) / 2)

        if nums[mid] > nums[mid + 1]:
            return self.binarySearch(nums, low, mid)

        return self.binarySearch(nums, mid + 1, high)

    def findPeakElement(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 0

        return self.binarySearch(nums, 0, len(nums) - 1)