class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        low = 0 
        high = len(nums)-1

        if len(nums) == 1 :
            return nums[0]

        while(low<=high):
            mid = low + (high-low) // 2

            # is target
            if (mid + 1 < len(nums) and nums[mid] < nums[mid+1])and (mid - 1 >= 0 and nums[mid] < nums[mid-1] ):
                return nums[mid]

            # target smaller 
            elif nums[mid] < nums[high] :
                high = mid

            # target bigger
            elif nums[mid] >= nums[low]:
                low = mid + 1

        return nums[mid]




# class Solution:
#     def findMin(self, nums: List[int]) -> int:

#         low, high = 0, len(nums) - 1

#         while (low <= high):
#             # completely sorted array

#             mid = low + (high - low) // 2
#             if nums[mid] < nums[mid - 1]:
#                 return nums[mid]
#             if nums[low] <= nums[mid] and nums[mid] <= nums[high]:
#                 return nums[low]

#             # if low == mid :

#             # return nums[low] if nums[low] < nums[mid] else nums[mid]
#             # left sorted meaning min on right array

#             if nums[mid] >= nums[low]:
#                 low = mid + 1

#             else:
#                 high = mid - 1


