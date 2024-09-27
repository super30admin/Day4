#Time Complextity: O(log n)
#Works on Leetcode: Yes

class Solution:
    def searchRange(self, nums, target):
        left = self.leftSearch(nums, target)
        right = self.rightSearch(nums, target)
        return [left, right]

    def leftSearch(self, nums, target):
        l, h = 0, len(nums)-1
        res = -1
        while(l<=h):
            mid = (l+h)//2
            if nums[mid]>target:
                h = mid-1
            elif nums[mid]<target:
                l = mid+1
            else:
                res = mid
                h = mid-1
        return res
    
    def rightSearch(self, nums, target):
        l, h = 0, len(nums)-1
        res = -1
        while(l<=h):
            mid = (l+h)//2
            if nums[mid]>target:
                h = mid -1
            elif nums[mid]<target:
                l = mid +1 
            else:
                res = mid
                l = mid+1
        return res

if __name__ == "__main__":
    a = [5,7,7,8,8,10]
    target = 8
    obj = Solution()
    print(obj.searchRange(a,target))