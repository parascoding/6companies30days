class Solution {
    public int minMutation(String startGene, String endGene, String[] b) {
        bank = new HashSet<>();
        for(String s : b){
            bank.add(s);
        }
        int ans = dfs(startGene, endGene, new HashSet<>());
        // System.out.println("ANS: " + ans);
        if(ans == Integer.MAX_VALUE - 100)
            ans = -1;
        return ans;
    }
    private int dfs(String s, String t, Set<String> hs){
        // System.out.println(s +" "+t+" "+hs);
        if(s.equals(t))
            return 0;
        hs.add(s);
        StringBuilder sb = new StringBuilder(s);
        int min = Integer.MAX_VALUE - 100;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 4; j++){
                sb.setCharAt(i, possib[j]);
                if(bank.contains(sb.toString()) && !hs.contains(sb.toString())){
                    // System.out.println(min);
                    int temp = dfs(sb.toString(), t, hs);
                    if(temp + 1 < min)
                        min = 1 + temp;
                    // System.out.println(min);
                }
            }
            sb.setCharAt(i, s.charAt(i));
        }
        hs.remove(s);
        // System.out.println(s +" "+t+" "+hs + " "+min);
        return min;
    }
    char possib[] = {'A', 'G', 'C', 'T'};
    Set<String> bank;
}
