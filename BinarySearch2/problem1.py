#Time Complexity: O(logn)
#Space Complexity: O(1)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #Main idea: seperate the two. Find target such that previous is smaller/next is bigger. normal binary search.
        #if it's target but previous not smaller,move right index to mid, for end position, moveleft index to mid.
        def start_position(nums,target):
            #edge case:
            if not nums:
                return -1
            low=0
            high=len(nums)-1
            while high>=low:
                mid=int(low+ (high-low)/2) #to avoid overflow
                if nums[mid]==target:
                    if mid==0 or nums[mid-1]<target:
                        return mid
                    else:
                        high=mid-1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return -1
        def end_position(nums,target):
            if not nums:
                return -1
            low=0
            high=len(nums)-1
             #to avoid overflow
            while high>=low:
                mid=int(low+ (high-low)/2)
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid+1]>target:
                        return mid
                    else:
                        low=mid+1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return -1

        return [start_position(nums,target),end_position(nums,target)]
