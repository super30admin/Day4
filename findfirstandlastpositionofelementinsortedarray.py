# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:

    def startIdx(self, nums, target):
        start, end = 0, len(nums) - 1

        while(start<=end):

            mid = start+ (end-start) // 2

            if nums[mid] == target and nums[mid-1]!=target and mid>0:
                return mid

            if nums[mid]<target:
                start = mid + 1
            else:
                end = mid - 1

    def endIdx(self, nums, target, startpos):
        start, end = startpos, len(nums) -1    

        while(start<=end):
            mid = start + (end-start) // 2

            if nums[mid] == target and nums[mid+1]!=target and mid<len(nums)-1:
                return mid

            if nums[mid]< target:
                start = mid + 1

            else:
                end = mid - 1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.startIdx(nums, target)
        end = self.endIdx(nums, target, start)
        return start,end


# We will divide this problem into 2 parts. 
# Getting start index is one binary search and getting end index is another binary search. And rest is getting 2 indexes using 2 bst and one condition to add is we need to make sure nums[m-1] !=target and in end position nums[m+1]!=target.