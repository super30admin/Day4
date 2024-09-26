from typing import List


class Solution:
    def findMin(self,Arr: List[int])->int:
        low=0
        high=len(Arr)-1
        last_element=Arr[-1]
        while low<=high:
            pivot_index=(low+high)//2
            if Arr[pivot_index]>last_element:
                if Arr[pivot_index]>Arr[pivot_index+1]:
                    return Arr[pivot_index+1]

                low=pivot_index+1
            else:
                high=pivot_index-1

        return Arr[0]