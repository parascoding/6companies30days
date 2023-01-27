class Solution {
    public int[] sortArray(int[] a) {
        int del = (int)5e4;
        int count[] = new int[2 * del + 10];
        for(int x : a)
            count[x + del]++;
        int ind = 0;
        for(int i = 0; i <= 2 * del; i++)
            while(count[i]-- > 0)
                a[ind++] = i - del;
        return a;
    }
}
