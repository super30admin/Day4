class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        right = 1
        while(reader.get(right)<target):
            right = right <<1
        left = right >> 1
        while (left<=right):
            mid = (left+right)//2
            if (reader.get(mid)==target):
                return mid
            elif(target>reader.get(mid)):
                left = mid+1
            elif(target<reader.get(mid)):
                right = mid-1
        return -1


