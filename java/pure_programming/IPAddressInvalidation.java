
//    给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//    所谓无效化IP地址，其实就是用 "[.]" 代替了每个 "."。
public class IPAddressInvalidation {
    public static void main(String[] args) {
        IPAddressInvalidation addressInvalidation = new IPAddressInvalidation();
        String result = addressInvalidation.invalidateIPAddr1("255.100.50.0");
        System.out.println("result is : " + result);
    }

    public String invalidateIPAddr(String address) {
        char[] array = address.toCharArray();
        //申请指定容量的数组newArray
        int newSize = array.length + 2 * 3;
        char[] newArray = new char[newSize];
        //遍历字符串，并将字符放到newArray中，当遇到.时，将[.]放入newArray中
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!='.') {
                newArray[j++] = array[i];
            } else {
                newArray[j++] = '[';
                newArray[j++] = '.';
                newArray[j++] = ']';
            }
        }
        //返回String类型的结果
        return new String(newArray);
    }

    public String invalidateIPAddr1(String address) {
        StringBuilder strBuilder = new StringBuilder();
        //遍历字符串，当遇到.时，将[.]放入strBuilder中
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                strBuilder.append(address.charAt(i));
            } else {
                strBuilder.append("[.]");
            }
        }
        return strBuilder.toString();
    }




}



