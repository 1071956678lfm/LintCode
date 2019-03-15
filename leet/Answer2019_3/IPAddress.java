package leet.Answer2019_3;

//468
public class IPAddress {
    /**
     * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
     * <p>
     * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
     * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
     * <p>
     * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
     * <p>
     * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
     * The groups are separated by colons (":").
     * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
     * Also, we could omit some leading zeros among four hexadecimal digits
     * and some low-case characters in the address to upper-case ones,
     * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
     * <p>
     * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
     * colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
     * <p>
     * Besides, extra leading zeros in the IPv6 is also invalid.
     * For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
     */
    public String validIPAddress(String IP) {
        String[] ipv6 = IP.split(":");
        String[] ipv4 = IP.split("[\\.]");
        String neither = "Neither";
        if (isNeight(IP))
            return neither;
        if (ipv6.length == 1) {
            return checkIPv4(ipv4, neither);
        } else if (ipv4.length == 1) {
            return checkIPv6(ipv6, neither);
        } else
            return neither;
    }

    private String checkIPv6(String[] ipv6, String neither) {
        if (ipv6.length != 8)
            return neither;
        for (int index = 0; index < ipv6.length; ++index) {
            String sub = ipv6[index];
            if (sub.length() > 4 || sub.equals(""))
                return neither;
            for (int i = 0; i < sub.length(); ++i) {
                if (!sub.substring(i, i + 1).matches("[0-9A-Fa-f]")) {
                    return neither;
                }
            }
        }
        return "IPv6";
    }

    private String checkIPv4(String[] ipv4, String neither) {
        if (ipv4.length != 4)
            return neither;
        for (int index = 0; index < ipv4.length; ++index) {
            String sub = ipv4[index];
            if (index != ipv4.length - 1 && sub.equals("0"))
                continue;
            if (sub.startsWith("0") || sub.equals(""))
                return neither;
            for (int i = 0; i < sub.length(); ++i) {
                if (!Character.isDigit(sub.charAt(i)))
                    return neither;
            }
            try {
                if (Integer.parseInt(sub) <= 0 || Integer.parseInt(sub) > 255)
                    return neither;
            } catch (Exception e) {
                return neither;
            }

        }
        return "IPv4";
    }

    private boolean isNeight(String ip) {
        return ip.startsWith(".") || ip.startsWith(":") || ip.endsWith(".") || ip.endsWith(":");
    }

    public static void main(String[] args) {
        System.out.println(new IPAddress().validIPAddress(("1.1.1.01")));
    }
}
