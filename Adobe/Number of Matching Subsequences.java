class Solution {
    public int numMatchingSubseq(String x, String[] s) {
        int count = 0;
        hm = new HashMap<>();
        for(String y : s){
            if(hm.containsKey(y)){
                count += (hm.get(y) ? 1 : 0);
                continue;
            }
            if(isSubsequence(x, y)){
                count++;
                hm.put(y, true);
            } else
            hm.put(y, false);
        }
        return count;
    }
    static boolean isSubsequence(String x, String y){
        int i = 0, j = 0;
        while(i < x.length() && j < y.length()){
            if(x.charAt(i) == y.charAt(j))
                j++;
            i++;
        }
        return j == y.length();
    }
    static Map<String, Boolean> hm;
}
