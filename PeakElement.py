def findPeakElement(self, nums):
    if nums==None or len(nums)==0 or len(nums)==1:
        return 0
    low = 0
    high = len(nums)-1
    while(low<=high):
        mid = low + (high-low)//2
        if (mid==high or nums[mid]>nums[mid+1]) and (mid==low or nums[mid]>nums[mid-1]):
            return mid
        elif nums[mid+1]>nums[mid]:
            low = mid  + 1
        else:
            high = mid - 1
            
    return 0