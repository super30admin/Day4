#Time complexity:O(logN)
#Space complexity:O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            
            mid=low+(high-low)//2
            if (nums[low]<=nums[high]):
                #If the array is already sorted we are returning the first element which is the smallest
                return nums[low]
            #Trying to check which side is sorted
            if ((mid==0 or nums[mid]<nums[mid-1])and (mid==len(nums)-1 or nums[mid]<nums[mid+1])):
                #Left side is sorted and low is moved to one place after mid pointer
                return nums[mid]
            elif(nums[mid]>=nums[low]):
                low=mid+1
            else:
                high=mid-1
        return 0

        