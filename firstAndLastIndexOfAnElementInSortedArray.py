#   ques: 34. Find First and Last Position of Element in Sorted Array

#   Time Complexity :
#   O(log n)

#  Space Complexity :
#  O(1)

#  Did this code successfully run on Leetcode :
#  Yes

#  Any problem you faced while coding this :
#  No

#  Your code here along with comments explaining your approach

class Solution:  
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        # Null or Empty array
        if (nums is None) or (len(nums) == 0):
            return [-1, -1]
        
        # Element is not in array bound
        if (nums[0] > target) or (nums[-1] < target):
            return [-1, -1]
        
        # If first and last elements of array are target
        if (nums[0] == nums[-1] == target):
            return [0, len(nums)-1]
        
        # Function to return first occurance of target
        def binarySearchFirst(nums, target):
            
            low = 0
            high = len(nums) - 1
            
            while(low<=high):
                
                mid = (low + high)//2
            
                if (nums[mid] == target):
                    # If mid element is equal to target and mid element is first element in array
                    # or mid element is greter than its previous element that means it the first
                    # occurance of target, so we will return mid element
                    if (mid==0 or nums[mid] > nums[mid-1]):
                        return mid
                    # If mid element is equal to target and it is not first occurance of target
                    # that is mid element is not first element in array and it is equal to its previous element
                    # then we will search left of mid element
                    else:
                        high = mid -1
                # If mid element is not equal to target
                # and it is smaller then target, then we will search right of mid for target
                elif (nums[mid] < target):
                    low = mid + 1
                # If mid element is not equal to target
                # and it is greater then target, then we will search left of mid for target
                else:
                    high = mid - 1
            
            # return -1 if element not found
            return -1
        
        # Function to return last occurance of target
        def binarySearchLast(nums, target):
            
            # Taking first occurance index as starting point to Search second occurance index
            low = firstIndex
            high = len(nums) - 1

            while(low<=high):
                mid = (low + high)//2

                if (nums[mid] == target):
                    if (mid==len(nums)-1 or nums[mid] < nums[mid+1]):
                        return mid
                    else:
                        low = mid + 1 
                elif (nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1

            return -1
        
        # Calling function to find first occurance of target
        firstIndex = binarySearchFirst(nums, target)
        
        # If target element not present no need to call funtion to find second occurance of target
        if firstIndex == -1:
            return [-1, -1]
        
        # Calling function to find last occurance of target
        lastIndex = binarySearchLast(nums, target)
        
        return [firstIndex, lastIndex]