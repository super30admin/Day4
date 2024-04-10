# Time Complexity : O(log N) for first BS and O(1) forst second BS
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

''' Given is sorted array with repeating integers with target given. Find the starting and ending position of a given target value. 
Logic applies binary search on array. Hint is that the minimum always lies in unsorted part of array from mid.'''

class Solution(object):
    def binarySearchLeft(self,nums,target): #Searches for the leftmost index of target in the given array of nums
        l=0
        h=len(nums)-1

        while l<=h:
            mid = l + (h-l)//2 #Formula to avoid integer overflow

            if nums[mid] == target: #check to further see if there are any elements on left of our mid which are equal to target
                if mid==l or nums[mid-1] != target: 
                    return mid
                elif nums[mid-1] == nums[mid]:
                    h=mid-1
            elif nums[mid]<target:
                l=mid+1
            else:
                h=mid-1
        return -1

    
    def binarySearchRight(self,nums,target,first,last): #Searches for the rightmost index of target in the given array of nums
        l=first
        h=last

        while l<=h:
            mid = l + (h-l)//2 #Formula to avoid integer overflow

            if nums[mid] == target: #check to further see if there are any elements on right of our mid which are equal to target
                if mid==h or nums[mid+1] != target:
                    return mid
                elif nums[mid+1] == nums[mid]:
                    l=mid+1
            elif nums[mid]<target:
                l=mid+1
            else:
                h=mid-1
        return -1


    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        if len(nums)==0 or nums==None: #Edge case
            return -1,-1
        if target < nums[0] or target > nums[len(nums)-1]: #Edge case
            return -1,-1

        firstindex = self.binarySearchLeft(nums,target)
        if firstindex == -1: #Means target is not present int he array, so no need to do second binary search to find right index
            return -1,-1 
        else:
            lastindex = self.binarySearchRight(nums,target, firstindex,len(nums)-1) #To optimize search, we are passing first index from first 
                                                    # binary search to search for the rightmost index instead of parsing entire array    

        return firstindex,lastindex


obj = Solution()
data = [1,2,3]
range = obj.searchRange(data,2)
print(range)