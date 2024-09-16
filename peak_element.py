class Solution:
    def findPeakElement(self, nums):
        # Brute force 
        # TC : O(n)
        # SC : O(1)
        
#         print("nums: ", nums)
#         i = 0
        
#         while(i <= len(nums) ):
            
#             if (i > 0 and i < len(nums)-1 ):
#                 # Check if i+1 and i-1 are less than the element
#                 if nums[i+1]< nums[i] and nums[i-1]< nums[i]:
#                     return i
#             elif (i == 0 and len(nums)>1):
#                 if nums[i + 1] < nums[i]:
#                     return i
#             elif (len(nums) == 1):
#                 return i
#             elif (i == len(nums) -1 ):
#                 if nums[i-1] < nums[i]:
#                     return i
            
#             i += 1
            
    
            # Binary search
            low = 0
            high = len(nums) - 1
            while(low <= high):
                mid = (low + high)//2
                
                if ((mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) -1 or nums[mid + 1] < nums[mid] )):
                    return mid
                
                elif (nums[mid] < nums[mid + 1]):
                    low = mid + 1
                else:
                    high = mid - 1
                
            
            
            
            
                
                
                
            
            
                
            
        
        