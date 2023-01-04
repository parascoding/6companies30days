class Solution {
    public int numberOfSubstrings(String S) {
        char s[] = S.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        int count = 0;

        int low = 0, high = 0, n = s.length;
        while(high < n){
            hm.put(s[high], hm.getOrDefault(s[high], 0) + 1);
            if(hm.size() == 3){
                while(low < high - 1 && hm.size() == 3){
                    count += n - high;
                    hm.put(s[low], hm.getOrDefault(s[low], 0) - 1);
                    if(hm.get(s[low]) == 0)
                        hm.remove(s[low]);
                    low++;
                }
            }
            high++;
        }
        return count;
    }
}
