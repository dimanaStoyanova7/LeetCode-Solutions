class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build the graph
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i =0; i<equations.size(); i++){
            double value = values[i];
            String element1 =  equations.get(i).get(0);
            String element2 =  equations.get(i).get(1);
            
            // TODO : add or upadte the value in the map
            map.computeIfAbsent(element1,k-> new HashMap<>()).put(element2, value);
            map.computeIfAbsent(element2,k-> new HashMap<>()).put(element1, 1/value);

        }
        double[] result = new double[queries.size()];
        for (int i=0; i<queries.size(); i++ ){
            List<String> query = queries.get(i);
            String element1 = query.get(0);
            String element2 = query.get(1);
            if(!map.containsKey(element1) || !map.containsKey(element2)){
                result[i]=-1;
            
            }
            else if(element1.equals(element2)){
                result[i]=1;
            }
            else {
                result[i] = dfs(element1, element2, 1.0, map, new HashSet<>());
            }
        }
        return result;
    }
    private double dfs(String curr, String target, double prod, Map<String, Map<String, Double>>map,  Set<String> visited){
        if(curr.equals(target)) return prod;
        visited.add(curr);
        for(Map.Entry<String, Double> entry: map.get(curr).entrySet()){
            String neighbour = entry.getKey();
            if(visited.contains(neighbour)) continue;
            double res = dfs(neighbour, target, prod* entry.getValue(), map, visited);
            if(res != -1.0) return res;
            
        }
        return -1;
    }
}