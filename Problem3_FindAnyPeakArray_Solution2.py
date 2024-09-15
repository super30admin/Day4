'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#162. Find Peak Element

# - Idea is to use binary search type mid
# - If nums[mid-1] <= nums[mid]  <= nums[mid+1]
# - If nums[mid-1] > nums[mid], then there definitely is a peak on left 
#   (high = mid-1)
# - If nums[mid+1] < nums[mid], then there definitely is a peak on the right
# - (low = mid + 1)

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - Binary search
#------------------
# Space Complexity: 
#------------------
# O(1) - Constant space to store indices and values


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :   ( 44 ms - 73.35 %ile)
# Space            :   ( 14.6 MB - 8.97 %ile)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low<=high:
            if low == high:
                return low

            if nums[low] > nums[low+1]:
                return low

            if nums[high] > nums[high-1]:
                return high

            mid = low + (high - low )//2

            if ((mid == 0 or nums[mid-1] < nums[mid]) and \
            (mid == len(nums)-1 or nums[mid+1] <= nums[mid])):
                return mid

            elif (mid>0) and nums[mid-1] > nums[mid]: 
                high = mid - 1

            else:
                low = mid + 1

        return -1

