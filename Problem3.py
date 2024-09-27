#problem 3
#complexity - O(log n)
#modify binary search
# compute the mid , check if it is greater than its neighbours
# if the mid is not greater than both its neighbours, then move towards the higher element
#################################################################
# contstraints - 1 <= nums.length <= 1000                       #
# Integer.MIN_VALUE <= nums[i] <= Integer.MAX_VALUE             #
# nums[i] != nums[i + 1] for all valid i                        #
#################################################################
def findPeakElement(nums):
    low, high = 0, len(nums)-1
    while(low <= high):
        mid = low + (high-low)//2
        if((mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1])):
            return mid
        elif (mid >0 and nums[mid] < nums[mid-1]):
            high = mid -1
        else:
            low = mid +1
    return -1


print(findPeakElement([2]))
print(findPeakElement([2,1]))
print(findPeakElement([1,2]))
print(findPeakElement([1,2,4,3,2,1]))