package com.vincent.util;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/16
 * @Modify
 * @since
 */
public class CheckIPDemo {

    public static void main(String[] args) {
        boolean s = isValidIpAddressV3("10.242.42.161");
    }

    public static boolean isValidIpAddressV3(String ipAddress) {
        char[] ipChars = ipAddress.toCharArray();
        int length = ipChars.length;
        int ipUnitIntValue = -1;
        boolean isFirstUnit = true;
        int unitsCount = 0;
        for (int i = 0; i < length; ++i) {
            char c = ipChars[i];
            if (c == '.') {
                if (ipUnitIntValue < 0 || ipUnitIntValue > 255) return false;
                if (isFirstUnit && ipUnitIntValue == 0) return false;
                if (isFirstUnit) isFirstUnit = false;
                ipUnitIntValue = -1;
                unitsCount++;
                continue;
            }
            if (c < '0' || c > '9') {
                return false;
            }
            if (ipUnitIntValue == -1) ipUnitIntValue = 0;
            ipUnitIntValue = ipUnitIntValue * 10 + (c - '0');
        }
        if (ipUnitIntValue < 0 || ipUnitIntValue > 255) return false;
        if (unitsCount != 3) return false;
        return true;
    }
}
