class Solution {
    public int maxPoints(int[][] a) {
        int n = a.length;
        int max = 0;
        if(n <= 2)
            return n;
        for(int i = 0; i < n; i++){
            Map<String, Integer> hm = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                int num = a[j][1] - a[i][1];
                int den = a[j][0] - a[i][0];
                int g = gcd(num, den);
                // if(g==0)
                // System.out.println(num + " " + den);
                num /= g;
                den /= g;
                String s = num + " " + den;
                hm.put(s, hm.getOrDefault(s, 0) + 1);
                max = Math.max(max, hm.get(s) + 1);
            }
        }
        return max;
    }
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
