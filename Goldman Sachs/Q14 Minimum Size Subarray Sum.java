class Solution {
    public int minSubArrayLen(int k, int[] a) {
        int min=Integer.MAX_VALUE;
        int i=0,j=0,n=a.length,sum=0;
        while(j<n){
            sum+=a[j++];
            while(sum>=k)
            {
                min=Math.min(min,j-i);
                sum-=a[i++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
