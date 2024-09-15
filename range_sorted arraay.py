class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l1 = l2 = 0
        r1 = r2 = len(nums)-1
        
        while l1 <= r1 or l2 <= r2:
            mid1 = l1 + (r1 - l1) // 2
            mid2 = l2 + (r2 - l2) // 2
            
            l_done = nums[mid1] == target and (mid1 == 0 or nums[mid1] > nums[mid1 - 1])
            r_done = nums[mid2] == target and (mid2 == len(nums)-1 or nums[mid2] < nums[mid2 + 1])
            
            if l_done and r_done:
                return [mid1, mid2]
            else:
                if l_done:
                    pass
                elif target <= nums[mid1]:
                    r1 = mid1 - 1
                else:
                    l1 = mid1 + 1
                
                if r_done:
                    pass
                elif target >= nums[mid2]:
                    l2 = mid2 + 1
                else:
                    r2 = mid2 - 1
        return [-1,-1]
                