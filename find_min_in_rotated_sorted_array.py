class solution (object):
    def findMin(self, nums):
        #check if the given array is empty or not
        if (nums==[] or len(nums)==0): #this is just a sanity check good practice to write in interview
            return -1
        low=0
        high=len(nums)-1
        
        while (low <= high):
            mid = low + (high-low)/2
            
            if ((mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            elif (nums[mid] > nums[high]):
                low mid + 1
            else:
                high = mid - 1
        return -1
