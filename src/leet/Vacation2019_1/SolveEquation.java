package leet.Vacation2019_1;

//640
public class SolveEquation {
    /**
     * Solve a given equation and return the value of x in the form of string "x=#value".
     * The equation contains only '+', '-' operation, the variable x and its coefficient.
     * <p>
     * If there is no solution for the equation, return "No solution".
     * <p>
     * If there are infinite solutions for the equation,
     * return "Infinite solutions".
     * <p>
     * If there is exactly one solution for the equation,
     * we ensure that the value of x is an integer.
     * <p>
     * Example 1:
     * Input: "x+5-3+x=6+x-2"
     * Output: "x=2"
     * Example 2:
     * Input: "x=x"
     * Output: "Infinite solutions"
     * Example 3:
     * Input: "2x=x"
     * Output: "x=0"
     * Example 4:
     * Input: "2x+3x-6x=x+2"
     * Output: "x=-1"
     * Example 5:
     * Input: "x=x+2"
     * Output: "No solution"
     */
    private static class Node {
        int val;
        Node next;

        Node(int v1, int v2) {
            this.val = v1;
            this.next = new Node(v2);
        }

        Node(int v) {
            this.val = v;
        }

        // Node -> ()x + ()
        Node(String str) {
            int v_x = 0;
            int v_c = 0;
            str = str.replaceAll("[-]", "+-");
            String[] strings =
                    str.split("[+]");
            for (String string : strings) {
                if (!string.equals("")) {
                    int index_x = string.lastIndexOf('x');
                    if (index_x != -1) {
                        switch (string) {
                            case "x":
                                v_x++;
                                break;
                            case "-x":
                                v_x--;
                                break;
                            default:
                                v_x += Integer.parseInt(string.substring(0, index_x));
                                break;
                        }
                    } else {
                        v_c += Integer.parseInt(string);
                    }
                }
            }
            this.val = v_x;
            this.next = new Node(v_c);
        }

        Node neg() {
            this.val = -val;
            this.next.val = -this.next.val;
            return this;
        }

        public Node add(Node n1, Node n2) {
            int v1 = n1.val + n2.val;
            int v2 = n1.next.val + n2.next.val;
            return new Node(v1, v2);
        }
    }

    private String solveEquation(String equation) {
        int equatorIndex = equation.indexOf('=');
        Node leftHead = new Node(equation.substring(0, equatorIndex));
        Node rightHead = new Node(equation.substring(equatorIndex + 1));
        Node ansNode = leftHead.add(leftHead, rightHead.neg());
        int v_x = ansNode.val;
        int v_c = ansNode.next.val;
        if (v_x == 0) {
            if (v_c == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + String.valueOf(-(v_c / v_x));
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolveEquation().solveEquation("-x=-1"));
    }
}
