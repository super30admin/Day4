# Note: Time complexity: O(logn)
#       Space complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            print(mid)
            # if (mid == 0 and  nums[mid+1]>=nums[mid]) or (mid == len(nums)-1 and nums[mid-1]>=nums[mid]) or (nums[mid-1]>=nums[mid] and nums[mid+1]>=nums[mid]):  # if both sides are greater

            if (mid == 0 or nums[mid - 1] >= nums[mid]) and (
                    mid == len(nums) - 1 or nums[mid + 1] >= nums[mid]):  # if both sides are greater
                return nums[mid]

            '''            
            NOTE: It won't work, because for all the rotated examples, the rotation is towards the left, and we need to find a minimum element
            
            # check if the left part is sorted
            if nums[low] < nums[mid]:
                low = mid + 1
                print(low, high)

            else:
                high = mid - 1
                print(low, high)
            '''

            if nums[mid] < nums[high]:
                high = mid - 1

            else:
                low = mid + 1

        return -1









