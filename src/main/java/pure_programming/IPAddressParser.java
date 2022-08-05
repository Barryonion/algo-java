//例题1：IP地址解析
//给定一个字符串表示的IP地址，比如“123.92.2.34"，判断其是否合法。合法IP地址的规则如下：
//a. 除了空格、数字和.之外，不得包含其他字符。
//b. IP地址由四个数字构成，由.分隔，每个.隔开的数字大小在0~255之间。
//c. 数字前后可以有空格，但中间不能有空格。比如" 123 .92.2.34"合法，“12 3.9 2.2.34"非法。

//当然，这个问题还可以继续加一些规则，让题目变得更加复杂，比如每个数字不能有前导0，但 可以为0。比如”021.3.02.34"非法，“0.2.0.33”合法。
public class IPAddressParser {
    public static void main(String[] args) {
        //测试用例
        //abc.123.123.234 非法      包含字母
        //123.134.132.22.242 非法   数字总数超出
        //257.123.12.15 非法        单个数字范围超出
        // 123 .12.11.1 合法        数字前后可以有空格
        //1 2 3.12.11.1 非法        数字中间有空格
        //111.12.12.1   合法
        //null 或者 ""   非法
        IPAddressParser parser = new IPAddressParser();
        boolean valid = parser.isValid("abc.123.123.234");
        System.out.println("expect abc.123.123.234 is false\n actual result is " + valid);
        boolean valid1 = parser.isValid("123.134.132.22.242");
        System.out.println("expect 123.134.132.22.242 is false\n actual result is " + valid1);
        boolean valid2 = parser.isValid("257.123.12.15");
        System.out.println("expect 257.123.12.15 is false\n actual result is " + valid2);
        boolean valid3 = parser.isValid(" 123 .12.11.1");
        System.out.println("expect  123 .12.11.1 is true\n actual result is " + valid3);
        boolean valid4 = parser.isValid("1 2 3.12.11.1");
        System.out.println("expect 1 2 3.12.11.1 is false\n actual result is " + valid4);
        boolean valid5 = parser.isValid("111.12.12.1");
        System.out.println("expect 111.12.12.1 is true\n actual result is " + valid5);
        boolean valid6 = parser.isValid(null);
        System.out.println("expect null is false\n actual result is " + valid6);
        boolean valid7 = parser.isValid("");
        System.out.println("expect  is false\n actual result is " + valid7);
        boolean valid8 = parser.check("021.3.02.34");
        System.out.println("expect  021.3.02.34 is false\n actual result is " + valid8);
        boolean valid9 = parser.check("0.2.0.33");
        System.out.println("expect  0.2.0.33 is true\n actual result is " + valid9);
    }

    public boolean isValid(String ip) {
        //判断是否为空
        if (null == ip || "".equals(ip)) {
            return false;
        }
        //判断以.分割后保存到数组中的字符串个数
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }
        //遍历数组，分别判断每一个字符串是否满足要求
        for (int i = 0 ; i < ipArr.length ; i++ ) {
            boolean res = checkSegment(ipArr[i]);
            if (!res) {
                return false;
            }
        }
        return true;
    }
    //判断分段的字符串是否满足要求
    // 123 .12.11.1
    private boolean checkSegment(String ipSegment) {
        int left  = 0;
        int right = ipSegment.length()-1;
        //判断字符串开头是否存在空格，如果存在，找到第一个不是空格的下标，来去掉所有连续的空格
        if (ipSegment.charAt(0) == ' ') {
            //找到第一个不是空格的下标 p
            for (int i = 1; i < ipSegment.length(); i++) {
                if (ipSegment.charAt(i) != ' ') {
                   left = i;
                   break;
                }
            }
        }
        //判断字符串结尾是否存在空格，如果存在，从后往前找到第一个不是空格的下标，来去掉所有连续的空格
        if (ipSegment.charAt(ipSegment.length()-1) == ' ') {
            //往前找到第一个不是空格的下标
            for (int i = ipSegment.length()-2; i>0 ; i--) {
                if (ipSegment.charAt(i) != ' ') {
                    right = i;
                    break;
                }
            }
        }
        //根据left和right下标截取字串
        String subIpSegment = ipSegment.substring(left, right+1);

        //遍历字符串，依次判断每一个字符，如果不是数字，那么返回false
        for (int i = 0 ; i < subIpSegment.length() ; i++) {
            if (!(subIpSegment.charAt(i) >= '0' && subIpSegment.charAt(i) <= '9')) {
                return false;
            }
        }

        //判断字串是否存在前导0，如果第一项是0，那么判断其是否存在后一项，若存在，则非法，不存在则合法
        if (subIpSegment.charAt(0) == '0') {
            if (subIpSegment.length()!=1) {
                return false;
            }
        }

        //计算字符串对应的整数值，判断其是否在0到255之间，如果不在，返回false
        int subInt = 0;
        for (int i = 0; i < subIpSegment.length(); i++) {
            //将数字字符转换成整数
            int value =subIpSegment.charAt(i) - '0';
            subInt = value + subInt * 10 ;
        }
        if (subInt > 255){
            return false;
        }
        return true;
    }

    //zheng's solution
    public boolean check(String ip) {
        if (ip == null) return false;
        String[] ipSegments = ip.split("\\.");
        if (ipSegments.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            boolean valid = checkSegment2(ipSegments[i]);
            if (!valid) return false;
        }
        return true;
    }

    private boolean checkSegment2(String ipSegment) {
        int n = ipSegment.length();
        int i = 0;
        //是否存在前导0？
        if (ipSegment.charAt(i) == '0' && ipSegment.length() != 1) {
            return false;
        }
        // 跳过前导空格，例如："   123"
        // charAt(i) 相当于 ipSegment[i]
        while (i < n && ipSegment.charAt(i) == ' ' ) {
            i++;
        }
        if (i == n) { // 字符串全是空格
            return false;
        }
        // 处理数字（将字符串转换成数字），例如："123   "
        int digit = 0;
        while (i < n && ipSegment.charAt(i) != ' ') {
            char c = ipSegment.charAt(i);
            if (c < '0' || c > '9') { // 非数字字符
                return false;
            }
            // c = '1' -> 1
            digit = digit * 10 + (c - '0');
            if (digit > 255) {
                return false;
            }
            i++;
        }
        // 处理后置空格，例如："123   " or "12 3"
        while (i < n) {
            char c = ipSegment.charAt(i);
            if (c != ' ') { //后面还有非空字符
                return false;
            }
            i++;
        }
        return true;
    }
    //对比发现：
    //法1需要反复从头遍历整个字符串
    //法2通过指针i，仅需遍历字符串一次 （效率更高）

}

















