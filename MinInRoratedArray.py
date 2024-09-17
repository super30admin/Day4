#Time Complexity : O(log n)
#Space Complexity : O(1)
#Problem run in leetcode : Yes
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
