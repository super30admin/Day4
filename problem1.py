# Time complexity = o(logn)
# Space complexity = o(1)

class Solution(object):
    def searchRange(self, nums, target):
        if len(nums) == 0:
            return [-1,-1]
        l,h,mid,pos1,pos2 = 0,len(nums)-1,0,-1,-1
        while l<=h:
            mid = int((l+h)/2)
            if nums[mid] > target:
                h = mid -1
                continue
            if nums [mid] < target:
                l = mid+1
                continue
            if nums[mid] == target:
                pos1,pos2 = mid,mid
                while pos1-1>=0:
                    if nums[pos1-1] == target:
                        pos1-=1
                        continue
                    else:
                        break
                while pos2+1 <= len(nums)-1:
                    if nums[pos2+1] == target:
                        pos2+=1
                        continue
                    else:
                        break
                return [pos1,pos2]
        return [pos1,pos2]
    