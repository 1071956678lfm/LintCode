package leet.Vacation2019_1;

public class Sqrt {
    public static int sqrt(int x) {
        if (x == 0) return 0;
        long i = x;
        while(i > x / i)
            i = (i + x / i) / 2;
        return (int)i;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2147395599));
    }
}
