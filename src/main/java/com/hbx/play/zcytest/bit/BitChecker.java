package com.hbx.play.zcytest.bit;

/**
 * @Auther: bingxin
 * @Date: 2019-10-15 13:24
 * @Description:
 */
public class BitChecker {

//    public static void main(String[] args) {
//
//        System.out.println(addByBit(3, 5));
//
//        System.out.println(jianfaByBit(3, 5));
//        System.out.println(jianfaByBit(3, -1));
//
//        System.out.println(chengfaByBit(3, -4));
//
//    }

    /**
     * 位运算加法
     * @param a
     * @param b
     * @return
     */
    public static int addByBit(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public static int jianfaByBit(int a, int b) {
        return addByBit(a, negNum(b));
    }

    /**
     * 求补码
     * @param n
     * @return
     */
    public static int negNum(int n) {
        return addByBit(~n, 1);
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    public static int chengfaByBit(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = addByBit(res, a);
            }
            b = b >>> 1;
            a = a << 1;
        }
        return res;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

//    public static void main(String[] args) {
//        System.out.println(getzhen整数中1的数量(5997));
//        System.out.println(getzhen整数中1的数量A(5997));
//        System.out.println(getzhen整数中1的数量B(5997));
//    }

    public static int getzhen整数中1的数量(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static int getzhen整数中1的数量A(int n) {
        int count = 0;

        while (n != 0) {
            n = n & n -1;
            count++;
        }
        return count;
    }

    public static int getzhen整数中1的数量B(int n) {

        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);

        return n;
    }

}