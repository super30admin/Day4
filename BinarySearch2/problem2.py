#Time Complexity:O(logn)
#Space Complexity: O(1)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:
class Solution:
    def findMin(self, nums: List[int]) -> int:
        #idea: the minimum element will always be on the unsorted side (mid is biggest of sorted side)
        #unless the whole array is sorted, then it's the first element
        #mid is min if both elements around are bigger (it's the pivot)\

        #no edge case
        low,high=0,len(nums)-1
        while high>=low: #it's possible that high is equal to low
            if nums[low]<=nums[high]:
                return nums[low]
            mid=int(low+(high-low)/2) # to avoid overflow
            if (mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                return nums[mid]
            #find unsorted side
            else:
                if nums[low]<=nums[mid]: #left is sorted, so move to the right
                    #it is possible that low is equal to mid ex [2,1]
                    low=mid+1
                else: #left is sorted, so move to the left
                    high=mid-1     
