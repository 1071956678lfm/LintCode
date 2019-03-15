package leet.Vacation2019_1;

/**
 * 273
 */
public class IntegerToEnglish {
    /**
     * Convert a non-negative integer to its english words representation.
     * Given input is guaranteed to be less than 2^31 - 1.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output: "One Hundred Twenty Three"
     * Example 2:
     * <p>
     * Input: 12345
     * Output: "Twelve Thousand Three Hundred Forty Five"
     * Example 3:
     * <p>
     * Input: 1234567
     * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * Example 4:
     * <p>
     * Input: 1234567891
     * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
     * <p>
     * <p>
     * ..
     * 12,345
     * 1,234,567,891
     * <p>
     * So we divide the num into 3-Nums parts
     */
    private String[] postFix = {
            "", "Thousand", "Million", "Billion", "Trillion"
    };
    private String[] One2Nine = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };
    private String[] tens = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"
    };
    private String[] ten2twenty = {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    public String numberToWords(int num) {
        String ans = "";
        String numStr = String.valueOf(num);
        int size = numStr.length();
        if (num == 0) {
            return "Zero";
        } else if (size <= 3) {
            return get3(numStr);
        }
        int time = size / 3; // 3 normal
        int rest = size % 3; // The last
        for (int i = 0; i < time; ++i) {
            int begin = size - (i * 3 + 3);
            int end = size - i * 3;
            String tmp = get3(numStr.substring(begin, end));
            ans = tmp + ' ' + (tmp.equals("") ? "" : postFix[i]) + ' ' + ans;
            ans=ans.trim();
        }
        if (rest != 0) {
            ans = get3(numStr.substring(0, rest)) + ' ' + postFix[time] + ' ' + ans;
        }
        return ans.trim();
    }

    /**
     * @param num : Range from 0 to 999
     * @return: The String val
     */
    private String get3(String num) {
        String ans;
        switch (num.length()) {
            case 3:
                if (num.charAt(1) != '1')
                    ans = One2Nine[ch2int(num.charAt(0))] +
                            ' ' +
                            (num.charAt(0) != '0' ? tens[10] : "") +
                            ' ' +
                            tens[ch2int(num.charAt(1))] +
                            (num.charAt(1) == '0' ? "" : " ") +
                            One2Nine[ch2int(num.charAt(2))];
                else
                    ans = One2Nine[ch2int(num.charAt(0))] +
                            ' ' +
                            (num.charAt(0) != '0' ? tens[10] : "") +
                            ' ' +
                            ten2twenty[ch2int(num.charAt(2))];
                break;
            case 2:
                if (num.charAt(0) != '1')
                    ans = tens[ch2int(num.charAt(0))] + " " +
                            One2Nine[ch2int(num.charAt(1))];
                else
                    ans = ten2twenty[ch2int(num.charAt(1))];
                break;
            case 1:
                if (num.equals("0"))
                    return "Zero";
                else
                    return One2Nine[ch2int(num.charAt(0))];
            default:
                return "";
        }
        return ans.trim();
    }

    private int ch2int(char ch) {
        return ch - '0';
    }

    public static void main(String[] args) {

        System.out.println(new IntegerToEnglish().numberToWords(1000010));
    }
}
