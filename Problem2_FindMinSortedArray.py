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
# Space            :   ( 14.5 MB - 58.78 %ile)


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        #For a single item element, we want to return nums[high] so we dont use
        # <=
        while low < high:
            mid = low + (high-low)//2
            
            if nums[mid] == nums[high]:
                #Reducing the high index because all elements after it will be
                #greater than nums[mid]
                high = high - 1
            
            elif nums[mid] > nums[high]:
                low = mid+1
            
            else:
                high = mid

        return nums[high]