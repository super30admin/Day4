class Solution:
    def findMin(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1
        while start <= end:
             # if array is not roated then smallest element will be at index 0
            if nums[start]<=nums[end]:
                return nums[start]
            mid = start +(end-start)//2 # to prevent integer overflow
            # if middle element is minimum then 
            if (mid == start or nums[mid-1] > nums[mid] )and (mid == end or nums[mid] < nums[mid+1]):
                return nums[mid]    
            # if left side is sorted as mim will always on unsorted part
            if nums[start] <= nums[mid]:
                start = mid+1
            # if right side is sorted as mim will always on unsorted part
            else: 
                end = mid-1
        



        
        
