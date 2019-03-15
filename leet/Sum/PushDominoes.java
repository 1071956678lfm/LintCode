package leet.Sum;

/**
 * 838
 */
public class PushDominoes {
    /**
     * There are N dominoes in a line, and we place each domino vertically upright.
     * <p>
     * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
     * <p>
     * <p>
     * <p>
     * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
     * <p>
     * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
     * <p>
     * When a vertical domino has dominoes falling on it from both sides,
     * it [stays still] due to the balance of the forces.
     * <p>
     * For the purposes of this question,
     * we will consider that a falling domino expends no additional force to a falling or already fallen domino.
     * <p>
     * Given a string "S" representing the initial state.
     * S[i] = 'L', if the i-th domino has been pushed to the left;
     * S[i] = 'R', if the i-th domino has been pushed to the right;
     * S[i] = '.', if the i-th domino has not been pushed.
     * <p>
     * Return a string representing the final state.
     * <p>
     * Example 1:
     * <p>
     * Input: ".L.R...LR..L.."
     * Output: "LL.RR.LLRRLL.."
     * Example 2:
     * <p>
     * Input: "RR.L"
     * Output: "RR.L"
     * Explanation: The first domino expends no additional force on the second domino.
     * <p>
     * Analyse:
     * 1.产生平衡的点,只在那些 R.......L  的中间,并且之间全为 .
     * 2.此外,其他全部的.都会被刷新,直到遇到了一个R或L
     */
    public String pushDominoes(String dominoes) {
        int opPtr = 0; //执行操作的指针,它的左侧字符串全部已经处理过
        char[] dominoesCH = dominoes.toCharArray();
        int startPos = 0;
        boolean toRight = false; //将. 转化为R , 发生在R与R中间,R与L的中点左侧,R与末尾
        boolean preDot = false;
        while (opPtr < dominoes.length()) {
            switch (dominoes.charAt(opPtr)) {
                case '.':
                    if (!toRight && !preDot) {
                        startPos = opPtr;
                    }
                    preDot = true;
                    break;
                case 'R':
                    preDot = false;
                    if (toRight) {  //Encounter another R .   case of R....R
                        replace(dominoesCH, startPos, opPtr - 1, 'R');
                    } else {        //start to move rightWard,but do not replace
                        toRight = true;
                    }
                    startPos = opPtr;
                    break;
                case 'L':
                    preDot = false;
                    if (!toRight) { //Not to right.
                        replace(dominoesCH, startPos, opPtr - 1, 'L');
                    } else {//the case of  R......L
                        int centerPos = (opPtr + startPos) / 2;
                        replace(dominoesCH, startPos, centerPos, 'R');
                        replace(dominoesCH, centerPos + 1, opPtr, 'L');
                        if ((opPtr + startPos) % 2 == 0) {
                            replace(dominoesCH, centerPos, centerPos, '.'); //reset the center pos
                        }
                        toRight = false;
                    }
                    startPos = opPtr + 1;
                    break;
                default:
                    break;
            }
            ++opPtr;
        }
        if (toRight) { //R ...... (end)
            replace(dominoesCH, startPos, opPtr - 1, 'R');
        }
        return String.valueOf(dominoesCH);
    }

    private void replace(char[] chars, int begin, int end, char ch) {
        for (int i = begin; i <= end; i++)
            chars[i] = ch;
    }

    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes("RLLL..LR....LL......LLR.RL...RRL..........R..L....RR.R..L.LR.L...L..LL.R.R.L.RR.....LRL.L.LL..LRR.L."));
    }
}
