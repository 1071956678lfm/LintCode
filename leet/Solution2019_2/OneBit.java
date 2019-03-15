package leet.Solution2019_2;

//717
public class OneBit {
    /**
     * We have two special characters. The first character can be represented by one bit 0.
     * The second character can be represented by two bits (10 or 11).
     * <p>
     * Now given a string represented by several bits.
     * Return whether the last character must be a one-bit character or not.
     * The given string will always end with a zero.
     * <p>
     * Example 1:
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character.
     * So the last character is one-bit character.
     * Example 2:
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character.
     * So the last character is NOT one-bit character.
     * <p>
     * we could have :
     * 10-11 / 11-10
     * 10-0 / 0-10
     * <p>
     * 101110
     * 0-11-0
     * <p>
     * len 3 : 10-0 0-0-0 11-0 0-10 0-11  -=-  001 111 101 均无法正常解码,需要接下去
     */
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        if (bits.length < 2) {//00
            return bits[0] == 0;
        }
        while (index + 3 < bits.length) {
            String subStr = String.valueOf(bits[index]) +
                    String.valueOf(bits[index + 1]) +
                    String.valueOf(bits[index + 2]);
            switch (subStr) {
                case "001":
                case "111":
                case "101":
                    index += 2;
                    break;
                default:
                    index += 3;
                    break;
            }
        }
        switch (bits.length - index) {
            case 1:
                return true;
            case 2:
                return bits[index] == 0;
            case 3:
                if (bits[index] == 0 &&
                        bits[index + 1] == 1)
                    return false;
                return true;
            default://0
                return false;
        }
    }

    private boolean Greedy(int[] bits){
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(new OneBit().isOneBitCharacter(bits));
    }
}
