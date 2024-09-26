"""
Approach:
1) Linear search brute force - O(n) time - Just go through array till you find the target and then keep moving until you don't find the target anymore
2) Binary search - O(logn) - find first element using binary search, then use the entire array and find the target. Once target is found, 
see if there is same number on the left side of the target, if so, continue binary search by setting high = mid -1
But, if there is no same element on the left side, or mid == 0 (meaning mid is at the beginning of the arr) then return mid.
Use the returned value from first Binary search to initialize lowForLast. Use that in binarySearchForLast element.
Run the similar search but this time if mid is equal to last index or nums[mid] < nums[mid+1] then return mid. Else increase low to mid+1

TC: O(logn) + O(logn) ==> O(logn)
"""


class Solution:
    lowForLast = 0
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0: return [-1,-1]
        if nums[0] > target or nums[-1] < target: return [-1,-1]
        
        first = self.binarySearchFirst(nums, target)
        if first == -1: return [-1,-1]
        self.lowForLast = first
        last = self.binarySearchLast(nums, target)
        return [first,last]
    
    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) -1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1
    
    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low, high = self.lowForLast, len(nums) -1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1