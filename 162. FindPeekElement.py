class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None:
            return -1
        n = len(nums)
        h = n-1
        l = 0
        while(l<=h):
            mid = (l + h)//2
            print(mid)
            if (mid==0 or nums[mid]> nums[mid-1]) and (mid==n-1 or nums[mid]>nums[mid+1]):
                print(mid)
                return mid
            elif (mid == n-1 or nums[mid+1]>nums[mid]):
                l = mid+1
            else:
                h = mid-1
        return -1