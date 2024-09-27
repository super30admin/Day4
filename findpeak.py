# In order to solve this question, try to plot the the points on a graph (Try the second example from leetcode question section for better understanding).
# Try to think it like this:
# Consider all the points are in the ascending order 1,2,3,4 in this case according to the information given by Leetcode nums[-1] = nums[n] = -∞.
# The array will look like this: -∞,1,2,3,4,-∞ and in this case our peak element will be 4 because its greater than its neighbour.
# Now considering our array 1,2,1,3,5,6,4, lets say that our mid is 3, in this case our answer can also be 2 i.e we can move the 
# binary search to the left side but the chances are less. But theres a guarentee that if we move towards the right side we are 
# gonna find a peak element. (If this sounds contradictory consider the ascending order example above).


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r=0,len(nums)-1
        
        while l<=r:
            mid=(l+r)//2
            
            #Handling edge cases like when mid is 0 and when mid is pointing towards the last element.
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            
            if nums[mid]<nums[mid+1]:
                l=mid+1
            else:
                r=mid-1
                
        return -1