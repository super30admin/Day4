#time complexity:o(logn)
#space complexity: o(1) not using any extra space
#passed all cases on LeetCode: dont have premium
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/


class Solution:
    def binarysearch(reader, target, low, high):
        while low <= high:
            mid = low + (high-low)//2
            if reader.get(target) == mid:
                return reader.get(target)
            elif (reader.get(target) < mid):
                high = mid -1
            else:
                low = mid+1
        return -1
            

    
    def search(self,reader,target):
        if(reader.get(0) == float('inf')): return -1

        low = 0
        high = 1
        #we are creating a lower and higher bound so that we can perform binary search on that
        # so have to move higher by a longer amount
        while(reader.get(high) < target):
            low = high
            high = high*2

       return self.binarysearch(reader, target, low, high)