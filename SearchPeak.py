#Time Complexity: O(logn)
#Space Complexity: O(logn)
#Did it run on leetcode: Yes

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums ) -1

        # array length is bigger than 2
        while left < right -1:
            mid = (left +right )//2
            if nums[mid] > nums[mid +1] and nums[mid] > nums[mi d -1]:
                return mid

            if nums[mid] < nums[mi d +1]:
                left = mid +1
            else:
                right = mid -1

        # array length is 1  -> return the only index ,array length is 2  -> return the bigger number's index
        return left if nums[left] >= nums[right] else right