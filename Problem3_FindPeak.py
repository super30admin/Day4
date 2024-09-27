#Time Complexity: O(logn)
#Space Complexity: O(1)
#Working on GitHub: Yes

class Solution:
    def findPeakElement(self, nums):
        l, h = 1, len(nums)-2
        if len(nums) == 1:
            return 0
        if nums[0]>nums[1]:
            return 0
        if nums[-1]>nums[-2]:
            return len(nums)-1

        while(l<=h):
            mid = (l+h)//2
            if nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid]<nums[mid-1]:
                h = mid-1
            elif nums[mid]<nums[mid+1]:
                l = mid+1
        

if __name__ == "__main__":
    obj = Solution()
    nums = [1,2,3,1]
    print("Index: ", obj.findPeakElement(nums))