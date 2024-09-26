//t.c: O(logn) S.C O(1)
class Solution {
public:
    int findMin(vector<int> &num) {
        int start=0,end=num.size()-1;
        
        while (start<end) {
            
            //this means that array is not rotated
            if (num[start]<num[end])
                return num[start];
            
            int mid = (start+end)/2;
            //pivot is in right of the mid
            if (num[mid]>=num[start]) {
                start = mid+1;
            } else {//pivot is in left of mid
                end = mid;
            }
        }
        
        return num[start];
    }
};
