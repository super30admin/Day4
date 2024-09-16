class Solution:
    def find_Peak(self, nums)
            l=len(nums)
            nums.append(-math.inf)
            left = 0
            right = len(nums)-1
            while left <= right:
                mid=(left+right)//2

                if mid!=-1 and mid!=left:
                    if nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                        return mid
                    if nums[mid] < nums[mid+1]:
                        left = mid+1
                    else:
                        right = mid -1
"""
Time Complexity = O(log n)
Space Complexity = O(1)

"""

"""
Binary Search Technique is applied.
Mid element is compared with the mid - 1 and mid + 1, If this satisfies index of the mid element is returned.
else Binary Search is continued.

"""
