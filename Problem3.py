class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums:
            low = 0
            high = len(nums)-1
            while low <= high:
                mid = low + (high - low)//2
                if((mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1])): #mid is the peak
                    return mid
                elif(mid !=0 and nums[mid]<nums[mid-1]): #element on the left side is higher, we move to left side
                    high = mid -1
                else:
                    low = mid + 1
            return -1
        
#Time Compelxity is O(log(n)) for binary search
#Space complexity is O(1)
                
                
        