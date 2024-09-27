#Time Complexity : OLOGN
#Space Complexity: O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end =len(nums)-1
        if nums[start] <= nums[end]:
            return (nums[start])
        else:
            while(start<=end):
                mid = (start + end)//2
                if (nums[mid] > nums[mid+1]):
                        return (nums[mid+1])
                elif nums[start] < nums[mid] :
                        start = mid
                elif nums[mid] < nums[end]:
                        end = mid
                elif nums[start]> nums[mid] and nums[mid] <nums[end]:
                        return (nums[mid])
                