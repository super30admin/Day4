#Time Complexity: O(log n)
#Space Complexity: O(1)
class solution:
    #input will be the array in which peak is to be found
    def findPeakElement(self, nums):
        #sanity check
        if nums==None or len(nums)==0:
            return (-1,-1)
        #only one element, thats the peak, check for it later
        
        #assign the low and high pointers
        low = 0
        high = len(nums)-1
        
        while (low <= high):
            mid = low + (high - low)//2
            
            #check if mid element is peak element then return index of mid
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
            #if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return (mid,mid)
            
            #modify low pointer
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
                
            #modify high pointer
            else:
                high = mid - 1
                
        return (-1)
