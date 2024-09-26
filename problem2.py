'''
Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
Explanation: Check if middle element is lesser than the element at the end of the array
If yes move to left side to get lease element else move to right side to get least element
'''

class Solution:
    def Itersearch(self, nums: List[int], low: int, high) -> int:
        while low < high:
            mid = int(low + ((high - low) / 2))
            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1

        return nums[low]

    def findMin(self, nums: List[int]) -> int:
        if nums == None:
            return -1

        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1
        return self.Itersearch(nums, low, high)

obj = Solution()
print(obj.findMin([3,4,5,1,2]))
