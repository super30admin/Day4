# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

 # if completely sorted return the first element
#check if mid is zero or if mid is smaller than mid - 1 as well as mid + 1 then return mid
#else check id low is smaller than mid then make mid + 1 as low otherwise bring high of mid - 1

def findMin(self, nums: List[int]) -> int:
    low = 0
    high =len(nums)-1
    while (low <= high):
       
        if nums[low]<= nums[high]:
            return nums[low]
        mid = low + (high - low) // 2
        
        if ((mid == 0 or nums[mid]< nums[mid-1])and nums[mid] <= nums[mid+1]):
            return nums[mid]
        elif nums[low] <= nums[mid]:
            low = mid +1

        else:
            high = mid-1
        

    return nums[low]                                                                         
    