class Solution {
    public int countNicePairs(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        long ans = 0, mod = (long)(1e9 + 7);
        for(int x : a){
            int ele = x - rev(x);
            // System.out.println(x + " "+ ele);
            ans = (ans + hm.getOrDefault(ele, 0)) % mod;
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }
        // System.out.println(hm);
        return (int)(ans);
    }
    static int rev(int n){
        int ans = 0;
        while(n > 0){
            int dig =  n % 10;
            ans = ans * 10 + dig;
            n /= 10;
        }
        return ans;
    }
}
