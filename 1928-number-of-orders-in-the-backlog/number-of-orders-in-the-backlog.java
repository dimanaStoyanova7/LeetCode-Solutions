class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // PQ for sell orders - smallest first
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // PQ for buy orders - biggest first
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a,b)->b[0]-a[0]); 
        // fill backlog with orders
        for(int[] order : orders){
            int type = order[2]; // 0 - buy; 1 - sell
            if(type==0){ // is a buy
                //inspect sell orders
                while(order[1] > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0]<=order[0]){
                    // we have found a match
                    int[] top = sellOrders.peek();
                    int quantity = Math.min(order[1], top[1]);
                    top[1]-=quantity;
                    order[1]-=quantity;
                    if(top[1]==0) sellOrders.poll();
                }
                if(order[1]>0){
                    buyOrders.offer(new int[]{order[0], order[1]});
                }
            }
            else if(type==1){ // is a sell
                while(order[1]>0 && !buyOrders.isEmpty() && buyOrders.peek()[0]>=order[0]){
                    int[] top = buyOrders.peek();
                    int amount = Math.min(top[1], order[1]);
                    order[1] -=amount;
                    top[1] -=amount;
                    if(top[1]==0) buyOrders.poll();
                }
                if(order[1]>0) sellOrders.offer(new int[]{order[0], order[1]});
            }
        }
        // return amount of orders remaining after placing all from the input
        long count = 0;
        for(int[] order : buyOrders){
            count += order[1];
        }
        for(int[] order : sellOrders){
            count += order[1];
        }
        return (int) (count%1_000_000_007);
    }
}