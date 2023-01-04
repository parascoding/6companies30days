class Solution {
    public String longestPrefix(String str) {
        char s[] = str.toCharArray();
        int lps[] = kmp(s, s.length);
        int max = -1, ind = -1;
        return str.substring(0, lps[s.length - 1]);
    }
    static int[] kmp(char s[], int n){
        int pi[] = new int[n];
        for(int i = 1; i < n; i++){
            int j = pi[i - 1];
            while(j > 0 && s[i] != s[j])
                j = pi[j - 1];
            if(s[i] == s[j])
                j++;
            pi[i] = j;
        }
        return pi;
    }
}
