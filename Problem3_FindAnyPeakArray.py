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
# Time             :   ( 32 ms - 99.6 %ile)
# Space            :   ( 14.4 MB - 70.20 %ile)


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        # We handle cases where low == high where the second element is always
        # going to be the peak
        while low<high:
            mid = low + (high - low )//2

            # If mid has reached left end, check if next element is < arr[mid]. 
            if mid == 0:

                #If yes, then its a peak
                if nums[mid+1] < nums[mid]:
                    return mid
                
                #Else break out of while. Array search over
                else:
                    break
            
            #If mid has reached right end check if prev element is < arr[mid]
            elif mid == (len(nums) - 1):
                if nums[mid-1] < nums[mid]:
                    return mid
                else:
                    break
            
            else:

                if (nums[mid-1] <= nums[mid]) and (nums[mid+1] <= nums[mid]):
                    return mid
               
                #Always move to greater side. Why?
                # We are sure that we will find the peak, why?
                # It already satisfies one condition
                # If both elements around mid are higher, it doesnt matter
                # which side we move
                elif (mid > 0) and (nums[mid-1] > nums[mid]): 
                    high = mid - 1
                
                else:
                    low = mid + 1

        return high
