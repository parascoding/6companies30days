class StockPrice {

    public HashMap<Integer, Integer> tm1;
    public TreeMap<Integer, Integer> tm2;
    public int cur, maxTime;
    public StockPrice() {
        tm1 = new HashMap<>();
        tm2 = new TreeMap<>();
        cur = -1;
        maxTime = -1;
    }
    
    public void update(int timestamp, int price) {
        if(tm1.containsKey(timestamp)){
            Integer temp = tm1.get(timestamp);
            tm2.put(temp, tm2.get(temp) - 1);
            if(tm2.get(temp) == 0)
                tm2.remove(temp);
        }
        tm1.put(timestamp, price);
        tm2.put(price, tm2.getOrDefault(price, 0) + 1);
        if(timestamp >= maxTime){
            maxTime = timestamp;
            cur = price;
        }
    }
    
    public int current() {
        return cur;
    }
    
    public int maximum() {
        return tm2.lowerKey(Integer.MAX_VALUE);
    }
    
    public int minimum() {
        return tm2.higherKey(Integer.MIN_VALUE);
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
