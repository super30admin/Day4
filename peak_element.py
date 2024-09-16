class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)-1
        if len(nums) < 2:   
            return 0
        if len(nums) ==2:
            if nums[0] > nums[1]:
                return 0
            else:
                return 1
        left = 0 
        right = n
        while left < right:
            mid = left + (right-left)//2
            if nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                return mid
            elif nums[mid] > nums[mid+1]:
                if mid == 0:
                    return 0
                right = mid
            elif nums[mid] < nums[mid+1]:
                if mid+1 == n:
                    return n
                left = mid + 1
        return len(nums)-1
            
            
            
'''
Points to note:
1. Two consecutive numbers can never be equal
2. There could be multiple peak elements and any peak idx can be returned
3. Binary Search Approach would work because the array is partially sorted 
BRUTE FORCE - traverse thriugh teh array and return the index if nums[i] > nums[i+1]
T(n) = O(n), S(n) = O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        arr_len = len(nums)
        if arr_len < 2:
            return 0
        for i in range(arr_len-1):
            if nums[i] > nums[i+1]:
                return i
        return arr_len-1
'''
