#Time Complexity: O(log n)
#Space Complexity: O(1)
#Did your code executed on leetcode : yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            
            #check whether entire array is sorted
            if nums[low] <= nums[high]: #<= because array might contain only one element
                return nums[low]
            
            #array is not fully sorted
            mid = low + (high - low)//2
            
            #check whether mid is smaller that previous and next element in list and here we are also going to check edge conditions
            
            if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums)-1 or nums[mid + 1] > nums[mid] ):
                return nums[mid]
            
            #if mid is not minimum then we check which part of array is sorted and minimum lies in unsorted part of array
            
            elif (nums[mid] >= nums[low]): #left side is sorted so move low
                low = mid + 1
            else:
                high = mid - 1
        
