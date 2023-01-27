class Solution {
    int a[], n;
    public Solution(int[] a) {
        this.a = a;
        this.n = a.length;
    }
    
    public int[] reset() {
        return a;
    }
    
    public int[] shuffle() {
        int s[] = new int[n];
        Set<Integer> hs = new HashSet<>();
        int count = 0;
        while(count < n){
            int ind = (int)(Math.random() * n);
            if(hs.add(ind)){
                s[count++] = a[ind];
            }
        }
        return s;
    }
}
