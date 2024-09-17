#time complexity: o(logn)
#space complexity: o(1)
#passed all cases on LeetCode: yes
#difficulty faced: choosing while condition - be careful or its an infinite loop, related to this moving high ptr
# comments:in the code
#https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution:
    def findMin(self, nums: 'List[int]') -> int:
        
        low = 0
        high = len(nums)-1
        
        #here the while loop cannot have "=" bec when low,mid and high all point to same element then 
        #this loop will keep repeating itself eg: [3,4,5,1,2] when low mid and high all point to 1 while condition keeps repeating
        while low < high:
            mid = low + (high-low)//2
            
            #in this case all numbers are unique so this is ok
            #this means array is pivoted somewhere right of mid and we will find least right of here
            if nums[mid] >= nums[high]:
                low = mid + 1
            #bec of the above arr condition, need to move high to mid and not mid-1 or we might get false result
            #eg:[3,1,2]
            else:
                high = mid
        return nums[low]        
        