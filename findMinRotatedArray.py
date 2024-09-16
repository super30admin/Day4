# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : I had trouble working out the conditioning but
# I think it was because I was overthinking and making it more complicated than required.

# Your code here along with comments explaining your approach
class Solution(object):
    # if array sorted low < high return low
    # if mid is less than both it's neighbors that implies,
    # that is where the array was rotated and that is min.
    # else move to unsorted part of the array and repeat
    def findMin(self, nums):
        left = 0
        right = len(nums) - 1
        while left <= right:
            if nums[left] <= nums[right]:
                return nums[left]
            mid = left + (right - left) / 2
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[mid] < nums[right]:
                right = mid - 1
            else:
                left = mid + 1
        return -1

nums = [4,5,6,7,8,-5,2]
s = Solution()
print s.findMin(nums)
