'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#702. Search in a Sorted Array of Unknown Size
# - Run two iterations of binary search. One to find start and one to find end

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - 2*logN. 1st logN to find the start. 2nd to find end
#------------------
# Space Complexity: 
#------------------
# O(1) - Constant space to store indices and values


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  80 ms (88.05 %ile)
# Space            :  15.3 MB (79.49 %ile)
from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        #Bin search for occurrence
        low = 0
        high = len(nums)-1

        start = -1
        end = -1

        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                start = mid
                high = mid-1
            elif nums[mid] < target:
                low = mid+1

            else:
                high = mid - 1

        high = len(nums)-1

        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                end = mid
                low = mid+1
            elif nums[mid] < target:
                low = mid+1

            else:
                high = mid - 1



        return [start, end]


obj = Solution()
print(obj.searchRange([5,7,7,8,8,10,12,12,12], 8))

        