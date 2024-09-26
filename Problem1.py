#Time complexity - O(logn) where n = len(nums)
#Space complexity - O(1)

#Basically, We run binary search twice to find the start and end position of the target occurance
#For the starting point, we need h=mid as it covers both cases where num[mid]>=target
#For end point, we need l = mid as it covers both cases where target>= num[mid]
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l,h = 0, len(nums)-1
        ans = [-1,-1]
        while l<h:
            mid = (l+h)//2
            if target>nums[mid]:
                l = mid+1
            else:
                h = mid
        if  not nums or nums[l]!=target:
            return ans
        else:
            ans[0]=l
        h = len(nums)-1
        while l<h:
            mid = (l+h)//2 +1
            if target<nums[mid]:
                h = mid-1
            else:
                l = mid
        ans[1]=h
        return ans
                