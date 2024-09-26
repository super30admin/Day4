"""
Approaches:
1) Linear search - Brute force - O(n) time
2) Binary search - O(log n) - Such that: Every time you find a sorted side you discard it. And look for mid in unsorted side
[4,5,6,7,0,1,2] -> initial mid will be at 7 , left side is sorted including 7 but right side is 7,0,1,2 - unsorted.
i) if nums[low] <= nums[high] -> return nums low
ii) If (mid ==0 or nums[mid] < nums[mid+1]) and (mid = len(nums)-1 or nums[mid]<nums[mid-1]) return nums[mid]
iii) else if nums[mid-1] > nums[mid] - h = mid -1 else l = mid +1
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1
        l, h = 0, len(nums) -1
        while l <= h:
            mid = l + (h-l) // 2
            # handle sorted array or array with all elements being same(although this leetcode problem doesn't allow all numbers to be same, all nums are expected to be unique)
            if nums[l] <= nums[h]: return nums[l]
            
            if ((mid ==0 or nums[mid] < nums[mid+1]) and
               (mid == len(nums)-1 or nums[mid] < nums[mid-1])):
                    return nums[mid]
            elif nums[mid-1] > nums[mid]:
            # elif nums[mid] < nums[mid+1]:
                h = mid - 1 
                # l = mid +1
            else:
                l = mid + 1
                # h = mid - 1 
        return -1