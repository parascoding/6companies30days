class Solution {
    public int distinctEchoSubstrings(String S) {
        char s[] = S.toCharArray();
        int n = s.length;
        Set<String> hs = new HashSet<>();
        for(int i = 1; i <= n / 2; i++){
            int count = 0;
            for(int low = 0, high = i; high < n; low++, high++){
                if(s[low] == s[high])
                    count++;
                else
                    count = 0;
                if(count == i){
                    hs.add(S.substring(low - i + 1, low + 1));
                    count--;
                }
            }
        }
        return hs.size();
    }
}
