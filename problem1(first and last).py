# Time Complexity : O(logn)
# Space Complexity :O(1)
class Solution:
    def leftbiarysearch(self, nums, target):
        l=0
        r=len(nums)-1

        while (l<=r):
            mid=l+(r-l)//2

            if  nums[mid]==target:
                if  mid==l or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    r=mid-1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
        return -1





    def rightbiarysearch(self, nums, target):
        l=0
        r=len(nums)-1

        while (l<=r):
            mid=l+(r-l)//2

            if nums[mid]==target:
                if  mid==r or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    l=mid+1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
        return -1




    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # using binary search algorithum \
        if nums is None:
            return [-1,-1]
        l=self.leftbiarysearch(nums,target)
        r=self.rightbiarysearch(nums,target)

        return [l,r]
