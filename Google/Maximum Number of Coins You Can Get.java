class Solution {
    public int maxCoins(int[] a) {
        int freq[] = new int[(int)1e4 + 1];
        for(int x : a)
            freq[x]++;
        int ind = 0;
        for(int i = 1; i <= 1e4; i++)
            while(freq[i]-- > 0)
                a[ind++] = i;
        int n = a.length;
        int low = 0, high = n - 2;
        int sum = 0;
        while(high > low){
            sum += a[high];
            high -= 2;
            low++;
        }
        return sum;
    }
}
