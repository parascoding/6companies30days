class Solution {
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        int n = p.length;
        int a[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            a[i][0] = p[i];
            a[i][1] = c[i];
        }
        Arrays.sort(a, 
            new Comparator<int[]>(){
                public int compare(int x[], int y[]){
                    return x[1] - y[1];
                }
            }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    return -a[x][0] + a[y][0];
                }
            }
        );
        int ind = 0;
        
        int count = 0;
        while(ind < n && count < k){
            while(ind < n && a[ind][1] <= w){
                pq.add(ind);
                ind++;
            }
            if(pq.isEmpty())
                break;
            int temp = pq.remove();
            w += a[temp][0];
            count++;
        }
        while(count < k && !pq.isEmpty()){
            count++;
            w += a[pq.remove()][0];
        }
        
        return w;

    }
}
