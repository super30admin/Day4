def binarySearch(nums, l, h):
    min = 5000
    
    while(l<=h):
        mid = (l + h) // 2
        if nums[mid] < min:
            min = nums[mid]
        if nums[l]<nums[mid] and nums[mid]>nums[h]:
            l = mid + 1
        else:
            h = mid - 1
    
    return min 
        
def findMin(nums):
    return binarySearch(nums,0,len(nums)-1)

nums = [11,13,15,17]

print(findMin(nums))