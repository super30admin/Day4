#162. Find Peak Element
#Time Complexity -> O(Log n)
#Space Complexity -> O(1)


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if(nums == None and len(num) == 0):
            return -1
        low = 0
        high = len(nums) - 1
        
        while(low<=high):
            
            mid = int(low+(high-low)/2)
            
            if(((mid == 0) or (nums[mid]>nums[mid-1])) and ((mid == len(nums)-1) or (nums[mid] > nums[mid +1]))):   
                return mid
            if(mid > 0 and nums[mid-1] > nums[mid]):
                high = mid -1
            else:
                low = mid +1 
        return -1
               
            