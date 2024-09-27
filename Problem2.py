class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums:
            low = 0
            high = len(nums) - 1
            while low <= high:
                if (nums[low]<nums[high]): return nums[low] # if the list is perfectly sorted
                mid = low + (high - low)//2 
                #line below checks if elements that are to left and right to mid are greater, also checks boundary
                if((mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1])):
                    return nums[mid]
                elif(nums[low] <= nums[mid]): #<= check valid even if there are 2 elements in the list
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


#Time Complexity is O(log(n)) where n is the input size as we are using binary search
#Space Complexity is O(1)