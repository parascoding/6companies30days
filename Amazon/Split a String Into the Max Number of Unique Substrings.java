class Solution {
    public int maxUniqueSplit(String s) {
        max = -1;
        dfs(s, 0, 0, new HashMap<>());
        return max;
    }
    static void dfs(String s, int ind, int last, Map<String, Integer> hm){
        if(ind == s.length()){
            max = Math.max(max, hm.size());
            // System.out.println(hm);
            return;
        }
        
        for(int i = ind; i < s.length(); i++){
            String t = s.substring(last, i + 1);
            hm.put(t, hm.getOrDefault(t, 0) + 1);
            dfs(s, i + 1, i + 1, hm);
            hm.put(t, hm.get(t) - 1);
            if(hm.get(t) == 0)
                hm.remove(t);
        }
        
        max = Math.max(max, hm.size());
    }
    static int max;
}
