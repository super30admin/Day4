'''
Time Complexity -->
O(n) in  worst time if all the elemnts are same otherwise O(logn)

Space Complexity -->
O(1) 

Approach -->
1. get the index from the list using binary search O(logn)
2. Once we get index check for lower index with same value
3. Similarly check for higher index with same value
4. return the lower and higher index
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        v = self.BinSearch(nums, 0, len(nums)-1, target)
        ls = []
        print(v)
        if v==-1:
            return [-1, -1]
        else:
            ls = []
            low = 0
            high = 0
            if v!=0 and nums[v]==nums[v-1]:
                low = v-1
                low-=1
                while low>=0 and nums[low]==nums[v]: #lower limit of the target element
                    low-=1
                low+=1
            else:
                low = v
                
            if v!=len(nums)-1 and nums[v]==nums[v+1]:
                high = v+1
                while high+1<len(nums) and nums[high+1]==nums[v]:  #higher limit of the target element
                    high+=1
                #high-=1
            else:
                high = v
                
            
            
            ls.append(low)
            ls.append(high)
            return ls
                        
    #Binary Seach
    def BinSearch(self, nums, l, r, target):
        while l<=r:
            mid = (l+r)//2
            if target==nums[mid]:
                return mid
            elif target>nums[mid]:
                l = mid+1
            else:
                r = mid-1
        return -1
        