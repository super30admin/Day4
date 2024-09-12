# Time Complexity : O(log(n)) for binarySearch. O(n) to find first and last index.
# Space Complexity : O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : We need to solve it in O(logn). But here though practically it should not be O(n), in worse case it is O(n).
# Need to discuss in class about ideal approach. 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(nums,start,end,target):
            while(start<=end):
                mid = (start + end)//2
                if nums[mid] == target:
                    return mid
                elif target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        res_start = binarySearch(nums,0,len(nums)-1,target)
        if res_start == -1:
            return [-1,-1]
        end = res_start
        res_end = res_start
        while(res_end != -1):
            res_end = binarySearch(nums,end+1,len(nums)-1,target)
            end = max(end,res_end)
        s = res_start
        e = res_start
        final_start = s
        res = res_start
        while(res != -1):
            s-=1
            e -= 1
            res = binarySearch(nums,s,e,target)
            if (res!= -1):
                final_start = s
            
        return [final_start,end]
