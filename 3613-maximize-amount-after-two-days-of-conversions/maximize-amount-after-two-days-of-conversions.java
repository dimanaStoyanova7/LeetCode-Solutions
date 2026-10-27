class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> day1 = amounts(initialCurrency, pairs1, rates1);
        Map<String, Double> day2 = amounts(initialCurrency, pairs2, rates2);
        double best = 1;
        for(String c : day1.keySet()){
            if(day2.containsKey(c)){
                best = Math.max(best, day1.get(c)/day2.get(c));   
            }
        }
        return best;
    }
    private Map<String, Double> amounts(String initCurr, List<List<String>> pairs, double[] rates){
        Map<String, List<String>> nbrs = new HashMap<>();
        Map<String, List<Double>> rts = new HashMap<>();
        for(int i =0 ; i< pairs.size(); i++){
            String a = pairs.get(i).get(0);
            String b = pairs.get(i).get(1);
            addEdge(a, b, rates[i],nbrs, rts);
            addEdge(b, a, 1/rates[i],nbrs, rts);
        }
        Map<String, Double> amt = new HashMap<>();
        amt.put(initCurr, 1.0);
        Deque<String> q = new ArrayDeque<>();
        q.add(initCurr);
        while(!q.isEmpty()){
            String v = q.poll();
            List<String> ne = nbrs.getOrDefault(v, List.of());
            List<Double> ra = rts.getOrDefault(v, List.of());
            for(int i =0 ; i< ne.size(); i++){
                String u = ne.get(i);
                if(!amt.containsKey(u)){
                    amt.put(u, amt.get(v) * ra.get(i));
                    q.add(u);
                }
            }
        }
        return amt;
    }
    private static void addEdge(String a, String b, double rate, Map<String, List<String>> nbrs, Map<String, List<Double>> rates ){
        nbrs.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        rates.computeIfAbsent(a, k -> new ArrayList<>()).add(rate);
    }
}