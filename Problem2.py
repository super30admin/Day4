#time complexity - O(log n ) -  modification of binary search
def findMin(nums) -> int:
    low, high = 0, len(nums)-1
    while(low <= high):
        if(nums[low] < nums[high]):
            return nums[low]
        mid = low + (high - low)//2
        if((mid == low or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid+1])):
            return nums[mid]
        elif(nums[low] <= nums[mid]):
            low = mid + 1
        else:
            high = mid -1
    return -1

print(findMin([1]))
print(findMin([1,2]))
print(findMin([2,1]))
print(findMin([1,2,0]))
print(findMin([4,5,6,7,0,1,2])