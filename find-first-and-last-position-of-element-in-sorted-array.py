'''
T.C: O(log N)
S.C: O(1)

Intuition: 
- Binary search until mid is equal to the target
- Three cases: 
    - mid btw range
    - mid - start of range
    - mid - end of range
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        num_len = len(nums)
        if not num_len:
            return [-1, -1]
        
        finx, finy = -1, -1
        start, end = 0, num_len - 1
        
        def findl(start, end, nums):
            while start <= end:
                mid = start + (end - start) // 2
                if start == end:
                    return start
                if nums[mid] < target:
                    start = mid + 1
                if nums[mid] == target:
                    if mid - 1 >= start:
                        if nums[mid - 1] == target:
                            end = mid - 1
                        else:
                            return mid
                    else:
                        return mid
                
        def findr(start, end, nums):
            while start <= end:
                mid = start + (end - start) // 2
                if start == end:
                    return start
                if nums[mid] > target:
                    end = mid - 1
                if nums[mid] == target:
                    if mid + 1 <= end:
                        if nums[mid + 1] == target:
                            start = mid + 1
                        else:
                            return mid   
                    else:
                        return mid 
                    
        while start <= end:
            mid = start + (end - start) // 2
            if start == end:
                return [finx, finy] if nums[start] != target else [start, start]
            if nums[mid] > target:
                end = mid - 1
            elif nums[mid] < target:
                start = mid + 1
            if nums[mid] == target:
                # case 1
                if nums[start] == target:
                    if finx == -1:
                        finx = start
                if nums[end] == target:
                    if finy == -1:
                        finy = end
                if nums[mid + 1] != target:
                    if finy == -1:
                        finy = mid
                if nums[mid - 1] != target:
                    if finx == -1:
                        finx = mid
                if finx == -1:
                    if nums[mid - 1] == target:
                        finx = findl(start, mid - 1, nums)
                    else:
                        finx = mid
                if finy == -1:
                    if nums[mid + 1] == target:
                        finy = findr(mid + 1, end, nums)
                    else:
                        finy = mid
                return [finx, finy]
        
        return [finx, finy]
                
        