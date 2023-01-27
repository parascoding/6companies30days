class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> hs = new HashSet<>();
        hs.add(dist(p1, p2));
        hs.add(dist(p2, p3));
        hs.add(dist(p3, p4));
        hs.add(dist(p4, p1));
        hs.add(dist(p1, p3));
        hs.add(dist(p2, p4));

        if(hs.size() == 2 && !hs.contains(0))
            return true;
        return false;
    }
    int dist(int p1[], int p2[]){
        return (p2[1] - p1[1])*((p2[1] - p1[1])) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
}
