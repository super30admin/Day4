class Solution:
    def binarySearch(self,reader,low,high,target):
        while(low<=high):
            mid=low+(high-low)//2
            if reader.get(mid)==target:
                return mid
            elif target>reader.get(mid):
                low=mid+1
            else:
                high=mid-1
        return -1
    def search(self, reader, target):
        low=0
        high=1
        while reader.get(high)<target:
            low=high
            high=2*high
        return(self.binarySearch(reader,low,high,target))

#TC: O(log n)
#SC: O(1)