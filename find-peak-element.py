#Approach: always go towards the element that is greater than mid
#Example [1,2,1,3,5,6,4]
#now l=1 and h=4 and m=3
# time complexity = O(logn)
# space complexity = O(1)
# If we have to find all peak elements or max peak element then it would be a O(n) solution

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n=len(nums)
        low=0
        high=len(nums)-1
        if n==1:
            return 0
        while low<=high:
            mid=low+(high-low)//2
            #Example [1,2,1,3,5,6,4]
            #now l=1 and h=4 and m=3
            # 3 > 1 correct but 3 > 5 false 
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==n-1 or nums[mid]>nums[mid+1]):
                return mid
            # above condition failed now eliminate half which is lower than mid; basically move towards higher element side 
            elif mid >0 and nums[mid-1]>nums[mid]:
                # if mid-1 is greater than move towards left and move high to mid -1 
                high=mid-1
            else:
                # if mid+1 > mid then move towards right means shift low
                low=mid+1
        return -1