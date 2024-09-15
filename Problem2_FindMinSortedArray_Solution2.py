'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#153. Find Minimum in Rotated Sorted Array

# - 

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
# Time             :   ( 36 ms - 87.29 %ile)
# Space            :   ( 14.5 MB - 83.09 %ile)

class Solution:
    def findMin(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        while low <= high:

            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high-low)//2

            #If mid is the min element, it will be less than mid-1 and mid +1
            # Need to check boundary conditions
            if ((mid == 0 or nums[mid] < nums[mid-1]) and \
                (mid == (len(nums)-1) or nums[mid] < nums[mid+1])):
                return nums[mid]

            #Left side is sorted
            if nums[mid] >= nums[low]:
                #Move to RHS
                low = mid+1

            else:
                #Move to LHS
                high = mid -1

        return nums[low]