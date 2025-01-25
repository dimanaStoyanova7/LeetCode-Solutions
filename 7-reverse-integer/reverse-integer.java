class Solution {
    public int reverse(int x) {
        if (x==0) return 0;
        int sign = (x<0) ? -1 : 1;
        x = Math.abs(x);
        int res =0;
        while(x>0){
            int digit = x%10;
            x/=10;
            //checks for bounds
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && digit > 7)) return 0;
            res = res*10+digit; 
        }
        return sign*res;
    
    }
}