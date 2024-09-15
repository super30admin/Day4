# TC = O(logn)
# SC = O(1)
# Using the finding index of smallest element function from Binary Search-1's Rotated Binary Search
class MinOfArray:
    def findMin(self, nums):
        def findIndexOfSmallestElement(left, right):
            if nums[left] < nums[right]: 
                return 0
            while left <= right:
                pivot = (left + right) // 2
                if nums[pivot] > nums[pivot + 1]: # if the element at pivot is greater than the next element in the middle of the array, the sorted array starts from next index
                    return nums[pivot + 1]
                else:
                    if nums[pivot] < nums[left]:
                        right = pivot - 1
                    else:
                        left = pivot + 1
        return findIndexOfSmallestElement(0, len(nums)-1)

# Driver code
obj = MinOfArray()
nums = [4,5,6,7,0,1,2]
print(obj.findMin(nums))