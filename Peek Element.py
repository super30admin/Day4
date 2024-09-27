#Time Complexity : OLOGN
#Space Complexity: O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start =0
        end =len(nums)-1
        if len(nums) == 0:
            return -1
        else:
            while(start <= end):
                mid = (start +end )//2
                if (nums[mid]> nums[mid-1] or mid ==0) and (mid == len(nums) -1 or nums[mid] > nums[mid+1] ):
                    return mid
                elif nums[mid] > nums[start]:
                    start = mid+1
                else:
                    end =mid-1