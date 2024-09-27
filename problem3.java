// ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
//time complexity:O(logn)
//explaination:
//we need to satify the condtion that  the neighboring elements of the target element are lesser than the element itself
//bascially e > e+1 and e> e-1 , however we also know that the issue will be there when we are targetting the end elements since both have only one neighnor to compare to
//edge cases to take care 1.if only one element 2.if two elements reutrn only one.
//leeetcode solution accepted
class Solution {
    public int findPeakElement(int[] num) {    
    return helper(num,0,num.length-1);
}

public int helper(int[] num,int start,int end){
    if(start == end){
        return start;
    }else if(start+1 == end){
        if(num[start] > num[end]) return start;
        return end;
    }else{
        
        int m = (start+end)/2;
        
        if(num[m] > num[m-1] && num[m] > num[m+1]){

            return m;

        }else if(num[m-1] > num[m] && num[m] > num[m+1]){

            return helper(num,start,m-1);

        }else{

            return helper(num,m+1,end);

        }
        
    }
}
}