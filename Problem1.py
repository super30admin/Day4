# Time Complexity : O(2logn) -> O(logn)
# Space Complexity : O(logn) -> call stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        if len(nums) == 1:
            if nums[0] == target:
                return [0,0]
            else:
                return [-1,-1]
        a = self.binarySearchLeft(nums,target,0,len(nums)-1)
        if a == len(nums) + 1:
            return [-1,-1]
        b = self.binarySearchRight(nums,target,0,len(nums)-1)       
        return [a,b]
        
    def binarySearchLeft(self,arr,target,l,r):
        if l>r:
            return len(arr) + 1
        mid = (l+r)//2
        if arr[mid] == target:
            return min(mid,self.binarySearchLeft(arr,target,l,mid-1))
        if arr[mid] > target:
            return self.binarySearchLeft(arr,target,l,mid-1)
        return self.binarySearchLeft(arr,target,mid+1,r)
    def binarySearchRight(self,arr,target,l,r):
        if l > r:
            return -1
        mid = (l+r)//2
        if arr[mid] == target:
            print(mid)
            return max(mid,self.binarySearchRight(arr,target,mid+1,r))
        if arr[mid] > target:
            return self.binarySearchRight(arr,target,l,mid-1)
        return self.binarySearchRight(arr,target,mid+1,r)
                       