package leet.integer_to_roam;

/**
 * int to Roman str
 */
public class solution {
    /*
     * We arrange the symbols into three sets
     *
     * 0-9 relate to the subset_1
     * 10 - 99 relate to the subset_2
     * 100 - 999 relate to the subset_3
     * 1000 - 9999 relate to subset_4
     * */
    private String[] subset_1 = {"I", "V", "X"};
    private String[] subset_2 = {"X", "L", "C"};
    private String[] subset_3 = {"C", "D", "M"};
    private String[] subset_4 = {"M", "", ""};//we could add more
    private String[][] symbols = {
            subset_1, subset_2, subset_3, subset_4
    };

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * 14 = 15 - 1
     * 13 = 10 + 3
     * <p>
     * special conditions occur when the bit is 4 or 9.
     * 4 = IV  9 = IX
     * 4x = XL[]  9x = CX[]
     * 4xx = CD[][]  9xx = MC[][]
     *
     * @param num :range from 1 to 3999
     */
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            //if timeOfTen == i,
            // then we put symbols[i]
            int timeOfTen = getTimeOfTen(num);
            String[] subSymbols = symbols[timeOfTen - 1]; //get the target sets
            int temp = (int) Math.pow(10, timeOfTen - 1);
            int bitVal = num / temp;//get the bit
            num -= bitVal * temp;
            result = result.append(bitToRoman(bitVal, subSymbols));
        }
        return result.toString();
    }

    private int getTimeOfTen(int val) {
        int count = 0;
        while (val > 0) {
            val /= 10;
            ++count;
        }
        return count;
    }

    /**
     * @param bit :single bit ,range from 0 to 9
     * @param set :the related symbol set
     * @return :the Roman symbol
     */
    private String bitToRoman(int bit, String[] set) {
        String result = "";
        if (bit < 4) {
            for (int i = 0; i < bit; i++)
                result += set[0];
            return result;
        } else if (bit > 4 && bit < 9) {
            result += set[1];
            for (int i = 0; i < bit - 5; i++)
                result += set[0];
            return result;
        }
        switch (bit) {
            //special conditions
            case 4:
                return set[0] + set[1];
            case 9:
                return set[0] + set[2];
            default:
                return null;
        }
    }

}
