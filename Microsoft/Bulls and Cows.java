class Solution {
    public String getHint(String Secret, String Guess) {
        char s[] = Secret.toCharArray();
        char g[] = Guess.toCharArray();
        int n = s.length;
        int freq1[] = new int[10];
        int freq2[] = new int[10];
        int bulls = 0, cows = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == g[i])
                bulls++;
            else {
                int d1 = (int)(s[i] - '0');
                int d2 = (int)(g[i] - '0');
                freq1[d1]++;
                freq2[d2]++;
            }
        }
        for(int i = 0; i < 10; i++){
            cows += Math.min(freq1[i], freq2[i]);
        }
        return bulls+"A"+cows+"B";
    }
}
