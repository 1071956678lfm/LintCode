package Questions;

import java.math.BigInteger;

public class SolutionQ_128 {
    /**
     * @param key:       A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key.length == 0) return 0;
        long result = (int) key[0];
        for (int i = 1; i < key.length; i++) {
            result = result * 33 % HASH_SIZE + (int) key[i];
        }
        result %= HASH_SIZE;
        return (int) result;
    }


    /*
    hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE

                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

     */
}
