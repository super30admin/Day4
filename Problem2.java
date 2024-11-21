// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution{

    public static int minValue(int[] a){
        int l=0, h= a.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[l]<=a[mid]){
                min=Math.min(min,a[l]);
                l=mid+1;
            }else{
                min=Math.min(min,a[mid]);
                h=mid-1;
            }
        }

        return min;
    }

    public static void main(String[] args){
        int[] a = {4,5,6,7,0,1,2};
        int[] b = {6,7,8,0,2,4,5};
        int[] c = {1,-2,-1};

        System.out.println(minValue(a));
        System.out.println(minValue(b));
        System.out.println(minValue(c));
    }


}