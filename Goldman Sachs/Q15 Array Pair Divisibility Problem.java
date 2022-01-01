
class Solution {
    public boolean canPair(int[] a, int k) {
        int n=a.length;
        hs=new HashSet<>();
        hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=a[i]%k;
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            hs.add(temp);
        }
        // System.out.println(hs);
        // System.out.println(hm);
        for(int x: hs){
            if(x==0){
                if(hm.get(x)%2!=0)
                return false;
            } else if(!hm.containsKey(k-x)||(hm.get(x)!=hm.get(k-x))){
                return false;
            }
        }
        return true;
    }
    private HashSet<Integer> hs;
    private HashMap<Integer,Integer> hm;
}
