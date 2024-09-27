#153. Find Minimum in Rotated Sorted Array
"""
Time Complexity : O(log n)
Space Complexity : O(1)
Problem run in leetcode : Yes
Any Problem faced : No

Using the fact that at least one side is sorted.
Logic here is to make low and high pointer pointing to first and last index of original array.
eg : original array : [1,2,3,4,5,6,7]
rotated given array : [4,5,6,7,1,2,3]
then low will point 7 and high will point 1.
And then in O(1) time complexity minimum if found out of both
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return nums[low]

        #binary search
        while (low < high):
            mid = low + (high - low) // 2

            # check if left is sorted. If it is, that means that right is non-sorted. Move access to RHS.
            if nums[low] <= nums[mid] and nums[mid] >= nums[high]:
                low = mid + 1

            #check if right is sorted. If it is, that means that left is non-sorted. Move access to LHS.
            elif nums[mid] <= nums[high] and nums[mid] <= nums[low]:
                high = mid #not doing high = mid - 1 because there is a chance that we miss min element
                           #in doing that.

            else: #if both side are sorted, then it means that while array is sorted.
                  # In that case minimum will be at low pointer.
                return nums[low]

        #Comparing low and high
        if nums[low] < nums[high]:
            return nums[low]
        else:
            return nums[high]