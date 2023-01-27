class Solution {
    public String predictPartyVictory(String S) {
        char s[] = S.toCharArray();
        Queue<Character> q = new LinkedList<>();
        int cr = 0, cd = 0;
        for(char c : s){
            q.add(c);
            if(c == 'R')
                cr++;
            else
                cd++;
        }
        int r = 0, d = 0;
        while(!q.isEmpty() && cd > 0  && cr > 0){
            char c = q.poll();
            if(c == 'R'){
                if(r > 0){
                    r--;
                    cr--;
                } else{
                    d++;
                    q.add(c);
                }
            } else{
                if(d > 0){
                    d--;
                    cd--;
                } else{
                    r++;
                    q.add(c);
                }
            }
        }
        if(cr > 0)
            return "Radiant";
        else 
            return "Dire";
    }
}
