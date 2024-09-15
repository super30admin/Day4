def findMin(self, nums):
    if nums == None or len(nums)==0:
        return -1
    low = 0
    high = len(nums)-1
    while(low<=high):
        mid = low + (high-low)//2
        if nums[low]<nums[high]:
            return nums[low]
        if (mid==low or nums[mid]<nums[mid-1]) and (mid==high or nums[mid] < nums[mid+1]):
            return nums[mid]
        elif nums[mid]>=nums[low]:
            low = mid + 1
        else:
            high = mid - 1
    return -1