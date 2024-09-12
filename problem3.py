#find peak element

# // Time Complexity : O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :slightly confused at first then we went over in class and it was clear





def findPeakElement( nums) -> int:
    if len(nums)==1:
        return 0
    low=0
    high=len(nums)-1
    while(low<=high):
        mid = low+(high-low)//2
        if((mid ==0 and nums[mid]>nums[mid+1]) or (mid ==len(nums)-1 and nums[mid]>nums[mid-1]) or (nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1])):
            return mid
        elif (mid !=len(nums)-1 and nums[mid]<nums[mid+1]):
            low=mid+1
        else:
            high=mid-1
    return 

#test
print(findPeakElement([1,2,1,3,5,6,4]))