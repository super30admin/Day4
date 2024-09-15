# TC = O(logn) using binary search
# SC = O(1)
# Struggled with edge cases for the "found" condition, cleared after class
# The idea is we consider the first half(arr[mid] < arr[mid-1]) or second half(arr[mid] < arr[mid+1])
# Found condition: arr[mid] is greater than left or right elements or first element greater than right element or last element greater than left element
# To remember: base conditions, found condition with edge cases and binary search doesnt require sorted array as a must condition !! 
class FindPeak:
    def findPeakElement(self, nums):
        if not nums or len(nums) == 0: return -1
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums)-1 or 
                                                            nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid-1]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

# Driver code
obj = FindPeak()
nums = [4,5,6,7,0,1,2]
print(obj.searcfindPeakElementh(nums))