class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        #We're going to be using a binary search algorithm for this problem
        #We're going to initialize our left and right pointers as so
        left, right = 0, len(nums) - 1
        
        #This will just help us keep track if mid is in range or not
        inRange = range(len(nums))
        
        #We'll check while left is less than right
        while left < right:
            
            #Our middle point
            mid = (left + right) // 2
            
            #Basically asking if the current array is of length 1, we return the only number we have
            if mid - 1 not in inRange and mid + 1 not in inRange:
                return mid
            
            #If the leftmost value is a peak it will fulfill this condition
            elif mid - 1 not in inRange and nums[mid] > nums[mid + 1]:
                return mid
            
            #If the rightmost value is a peak it will fulfill this condition
            elif mid + 1 not in inRange and nums[mid] > nums[mid - 1]:
                return mid
            
            else:
                
                #We're at a peak, so we just return it
                if nums[mid - 1] < nums[mid] > nums[mid + 1]:
                    return mid
                
                #We want to go upwards, we so prefer going left if that value is larger.
                #If doesn't matter if we find the maximum peak in the entire array, we're just looking for a local max
                elif nums[mid - 1] >= nums[mid]:
                    right = mid
                    
                #If the opposite is true we'll look right
                elif nums[mid + 1] > nums[mid]:
                    left = mid + 1
        
        
        #If we never found a peak, i.e. array length of two we just have this to correct itself
        mid = (left + right) // 2
        if mid + 1 in inRange:
            if nums[mid + 1] > nums[mid]:
                return mid + 1
        return mid