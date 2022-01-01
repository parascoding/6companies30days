class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k){
        int i=0,j=0;
        int max=0;
        long prod=1;
        while(j<n){
            prod*=a[j];
            while(i<j&&prod>k)
            prod/=a[i++];
            if(prod<k){
                max+=(j-i+1);
            }
            j++;
        }

        return max;
    }
}
