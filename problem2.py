#time complexity: O(log(n))
#space complexity: O(1)
#run on leetcode: yes
# if nums[low]<nums[high] this means array is sorted so return nums[low] as minimum. 
# If the array is not sorted then the minimum element always lies on the unsorted side so adjust low and high 
#acccordingly and perfom binary search
class Solution:
    def findMin(self, nums):
        if(len(nums)==1):
            return nums[0]
        low=0
        high=len(nums)-1
        while(low<=high):
            if(nums[low]<nums[high]):
                return nums[low]
            mid=(low+high)//2
            if(nums[mid]<nums[mid-1] and (nums[mid]<nums[mid+1])):
                return nums[mid]
            #check if left part is sorted
            if(nums[low] <=nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return 34343

s=Solution()
nums=[4,5,6,7,0,1,2]
print(s.findMin(nums))

