class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        long ugly[]=new long[n];
        long next2=2l,next3=3l,next5=5l;
        ugly[0]=1;
        int i2=0,i3=0,i5=0;
        long next=0;
        for(int i=1;i<n;i++){
            next=Math.min(next2,Math.min(next3, next5));
            ugly[i]=next;
            if(next==next2){
                i2++;
                next2=ugly[i2]*2;
            } if(next==next3){
                i3++;
                next3=ugly[i3]*3;
            } if(next==next5){
                i5++;
                next5=ugly[i5]*5;
            }
        }
        return next;
    }
}
