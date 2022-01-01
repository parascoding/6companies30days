class Solve {
    int[] findTwoElement(int a[], int n) {
        int ans1=0,ans2=0;
        for(int i=0;i<n;i++){
            int temp=Math.abs(a[i]);
            if(a[temp-1]>0)
            a[temp-1]=-a[temp-1];
            else
            ans1=temp;
        }
        for(int i=0;i<n;i++)
        if(a[i]>0)
        ans2=i+1;
        return new int[]{ans1,ans2};
    }
}
