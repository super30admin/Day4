# problem 1 : 34. Find First and Last Position of Element in Sorted Array
# Time Complexity : O(log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
## modifies binary search first to find the first position of the element then to find last position
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = -1, -1
        
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r) // 2
            if nums[mid] == target:
                if mid -1 >= 0 and nums[mid-1] == target:
                    r = mid -1
                elif mid - 1 == -1 :
                    left = 0
                    break
                else:
                    left = mid
                    break
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        
                    
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r) // 2
            if nums[mid] == target:
                if mid +1 < len(nums) and nums[mid+1] == target:
                    l = mid +1
                elif mid + 1 == len(nums) :
                    right = len(nums) - 1
                    break
                else:
                    right = mid
                    break
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return [left, right]



# problem 2 : 153. Find Minimum in Rotated Sorted Array - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
# Time Complexity : O(log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
## Binary search with considering the edge cases
class Solution:
    def findMin(self, nums: List[int]) -> int:
        start, end = 0, len(nums) - 1
        while start < end:
            if nums[start] < nums[end]:
                return nums[start]
            mid = start + (end- start) // 2
            if mid > 0 and nums[mid-1] > nums[mid]:
                return nums[mid]
            elif nums[mid] > nums[end]:
                start = mid + 1
            else:
                end = mid - 1
        return nums[start]
        
        ## another solution : Reducing the search space till only one nuumber is left
#         while start < end:
#             mid = start + (end- start) // 2
#             if nums[end] > nums[mid]:
#                 end = mid
#             else:
#                 start = mid + 1
#         return nums[start]
                

# problem 3 : 162. Find Peak Element - https://leetcode.com/problems/find-peak-element/
# Time Complexity : O(log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
## Binary search considering the logic for this given problem.
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # if len(nums) == 1:
        #     return 0
        # start, end = 0, len(nums) - 1
        # while start < end:
        #     mid = start + (end - start) // 2
        #     if (mid == start and nums[mid] > nums[mid+1]):
        #         return mid
        #     elif (mid == start):
        #         return mid +1
        #     elif (nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]):
        #         return mid
        #     elif nums[mid-1] < nums[mid] < nums[mid+1]:
        #         start = mid + 1
        #     elif nums[mid+1] < nums[mid] < nums[mid-1]:
        #         end = mid - 1
        #     elif nums[mid+1] > nums[mid-1]:
        #         start = mid + 1
        #     else:
        #         end = mid - 1
        # return start

        ## better solution
        if len(nums) == 1:
            return 0
        start, end = 0, len(nums) - 1
        while start < end:
            mid = start + (end - start) // 2
            if nums[mid] > nums[mid+1]:
                end = mid
            else:
                start = mid + 1
        return start
