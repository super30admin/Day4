# // Time Complexity : # we will have O(logn) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def findMin(self, nums):
#take a var result that will keep track of the min value so far, initialised with first value in the array
        res=nums[0]
        start=0
        end=len(nums)-1
        
        while start<=end:
            #first check if left is currnt start less than the end then we check for the min 
            #that means array is already sorted
            if nums[start] < nums[end]:
                #check if mid is the new minimum
                res= min(res ,nums[start])
                break
            #now when array is not sorted
            mid=(start+end)//2
            #check if mid is min
            res= min(res,nums[mid])
            #if array is left sorted
            if nums[mid]>=nums[start]:
                start=mid+1
            else:
                #right sorted 
                end=mid-1
        return res