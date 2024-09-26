class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        self.final = [-1,-1]
        # self.high = len(nums) - 1
        # self.low = 0
        def binary(l,r):
            if l > r:
                return
            mid = int((l+r)/2)
            if nums[mid] == target:
                self.final[0] = min(mid,self.final[0]) if self.final[0] != -1 else mid
                self.final[1] = max(mid,self.final[1]) if self.final[1] != -1 else mid
                binary(l,mid-1)
                binary(mid+1,r)
            elif nums[mid] > target:
                binary(l,mid-1)
            else:
                binary(mid+1,r)
        binary(0,len(nums)-1)
        return self.final