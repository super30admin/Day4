#Explanation

"Always remember the minimum element in a rotated sorted array will be on the unsorted side"
"Hence we will check which side of the array is sorted, and move to the other side"

"One more important point to be noted here is that, to check which side of the array is sorted, always prefer comparing MID and END, not MID and START"
"Next important point to be noted here is that, the minimum point will always be the pivot point, from where the sorted array has been rotated"

"Here since, we dont have any base case, to check if the mid is what we want, we should consider mid, while moving to the unsorted side"

class Solution:
    def findMin(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1

        while(start < end):
            mid = (start + end) // 2

            if nums[mid] < nums[end]:
                end = mid
            else:
                start = mid + 1
        return nums[start]
        