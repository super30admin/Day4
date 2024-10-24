def binarySearch(nums, l, h):
    while(l<=h):
        mid = (l + h)//2
        if mid == 0 and mid == len(nums)-1:
            return mid
        if mid == 0:
            if nums[mid]>nums[mid+1]:
                return mid
            else:
                l= mid + 1
        elif mid == len(nums)-1:
            if nums[mid]>nums[mid-1]:
                return mid
            else:
                h = mid - 1 
        elif nums[mid-1] < nums[mid] and nums[mid+1]<nums[mid]:
            return mid
        elif nums[mid-1]>nums[mid]:
            h = mid - 1
        else:
            l = mid + 1
        

def findPeakElement(nums):
    return binarySearch(nums, 0, len(nums)-1)


nums = [1,2,1,3,6,4]

print(findPeakElement(nums))