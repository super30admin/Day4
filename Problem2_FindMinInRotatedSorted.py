#Time Complexity: O(logn)
#Works on LeetCode: Yes


class Solution:
    def findMin(self, nums):
        l, h = 0, len(nums)-1
        min_ = nums[0]
        while(l<=h):
            mid = (l+h)//2
            if nums[l]<nums[h]:
                min_ = min(min_, nums[l])
                break
            
            min_ = min(min_, nums[mid])
            if nums[mid]>nums[l]:
                l = mid+1
            else:
                h = mid-1
        return min_

if __name__ == "__main__":
    obj = Solution()
    a = [4,5,6,7,0,1,2]
    b = [3,4,5,1,2]
    print(obj.findMin(a)) 
    print(obj.findMin(b))