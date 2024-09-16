#time complexity is o(log(n))
#we compare the elemtns next to mid to see if the mid is the peak element, if not we run binary search 
#on either side of mid to find the peak element.

def findPeakElement(nums):
    length = len(nums)
    low = 0
    high = length - 1
    while (low <= high):     
        middle = (low + high) // 2
        if (nums[middle - 1] <= nums[middle]) and (nums[middle] >= nums[middle + 1]):
            return middle
        elif (nums[middle - 1] > nums[middle]):
            high = middle - 1
        else:
            low = middle + 1
    return -1

print(findPeakElement([1,2,3,1]))
