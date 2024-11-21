// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Problem3 {
    
    public static int peakElement(int[] a){
        int l=0, h=a.length-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(a[mid]>a[mid+1]){
                h=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args){
        int[] a = {1,2,1,3,5,3,4,7};
        System.out.println(peakElement(a));
    }

}