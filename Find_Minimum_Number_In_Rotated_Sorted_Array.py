class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)<=1:
            return min(nums)
        left = 0
        right = len(nums)-1
        ans = float("-inf")
        last=nums[-1]
        if nums[0]<=nums[-1]:
            return nums[0]
        while(left<=right):
            mid = left + (right-left)//2
            if nums[mid]>last:
                ans = max(mid,ans)
                left = mid+1
            else:
                right = mid-1
        return nums[ans+1]
    #Time Complexity:O(logn)
    #Space Complexity: O(1)
                