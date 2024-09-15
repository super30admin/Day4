class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1     
		#case of strictly increasing array
        if nums[low]<=nums[high]:
            return nums[low]
        #for array rotated <n number of times array nums[low]>nums[high] always
        while(low<high):
            mid = (low+high)//2
            #check the mid point
            if mid>=1 and nums[mid-1]>nums[mid]:
                return nums[mid]
            elif mid<n-1 and nums[mid+1]<nums[mid]:
                return nums[mid+1]
            #check where the mid point lies 
            #in the first half of the gradation or in the second half of gradation.
            #change the pointers accordingly
            if nums[mid]<nums[high]:
                high = mid-1
            else:
                low =mid+1  