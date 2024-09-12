#LC 153
#  Find Minimum in Rotated Sorted Array
# Time Complexity : O(log N)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low < high: #The reason I have not used less than equal to here is because in that case it will go into an infinite loop
            mid = (low+high)//2
            if nums[mid] > nums[high]:
                low = mid+1
            else:
                high = mid
        return nums[low]
        