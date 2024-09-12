# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]

        s, e = 0, len(nums)-1

        if nums[s] < nums[e]:
            return nums[s]

        while (s<=e):
            m = s + (e-s)-1

            if (nums[m] < nums[m-1]):
                return nums[m]

            if(nums[m] > nums[m+1]):
                return nums[m+1]

            if(nums[m] > nums[s]):
                s = m + 1

            if(nums[m] < nums[s]):
                e = m - 1

# Keep handling the cases one by one, if not any of the special case is handled consider BST.  1st is if len(arr)==1 then return arr[0]. 2nd is if start<end then return start. 
# And then start BST and then couple more conditions inside that. if arr[mid]<arr[mid-1] then return arr[mid]. And next condition is arr[m]>arr[m+1] then return arr[m+1] and if this is not satisfided then apply normal BST for start and end updation.