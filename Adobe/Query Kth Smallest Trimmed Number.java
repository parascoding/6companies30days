class Solution {
    public int[] smallestTrimmedNumbers(String[] s, int[][] q) {
        int m=q.length;
        int n = s.length;
        int ans[]=new int[m];
        for(int i=0;i<m;i++)
            ans[i]=find(s,q[i][0], q[i][1]);
        return ans;
    }
    static int find(String s[], int k, int trim){
        List<Node> list=new ArrayList<>();
        int len =s[0].length();
        
        for(int i=0;i<s.length;i++){
            list.add(new Node(s[i].substring(len - trim), i));
        }
        Collections.sort(list,
            new Comparator<Node>(){
                public int compare(Node n1, Node n2){
                    return n1.s.compareTo(n2.s);
                }
            }
        );
        return list.get(k-1).ind;
    }
    static class Node{
        String s;
        int ind;
        Node(String s, int ind){
            this.s=s;
            this.ind=ind;
        }
    }
    
}
