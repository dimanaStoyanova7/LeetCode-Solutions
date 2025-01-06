class Solution {
    public static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static final String[] belowTrenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] belowHundred={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convertToWords(num);
    }
    public String convertToWords(int num) {
        if(num<10) return belowTen[num];
        if(num<20) return belowTrenty[num-10];
        if(num<100) return belowHundred[num/10] + (num%10!=0 ? " "+convertToWords(num%10):"");
        if(num<1000){
            return convertToWords(num/100) + " Hundred" +
            (num%100!=0 ? " "+convertToWords(num%100):"");
        }
        if(num<1000000){
            return convertToWords(num/1000) + " Thousand" +
            (num%1000!=0 ? " "+convertToWords(num%1000):"");
        }
        if(num<1000000000){
            return convertToWords(num/1000000) + " Million" +
            (num%1000000!=0 ? " "+convertToWords(num%1000000):"");
        }
        return convertToWords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWords(num % 1000000000) : "");

    }
}