package com.hbx.play.zcytest.other;

/**
 * @Auther: bingxin
 * @Date: 2019-10-22 16:44
 * @Description:
 */
public class OtherPot {

//    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 0; i < 10000; i++) {
//            if (getRadom7ByRandom5() == 1) {
//                count++;
//            }
//        }
//        System.out.println(count);
//        System.out.println((double) count / 10000);
//        System.out.println(1.0 / 7);
//    }

    /**
     * 产生1 - 7的随机数
     * @return
     */
    public static int getRadom7ByRandom5() {
        int num = 0;
        do {
            num = (rand1To5() - 1) * 5 + rand1To5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }

    public static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 产生 1 - 10的数根据1-7 https://leetcode-cn.com/problems/implement-rand10-using-rand7/submissions/
     * @return
     */
    public static int getRadom10ByRandom7() {
        int num = 0;
        do {
            num = (getRadom7ByRandom5() - 1) * 7 + (getRadom7ByRandom5() - 1); // (0 ~ 49)
        } while (num >= 39);
        return num % 10 + 1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int rand01p() {
        double p = 0.91; // 可以随意改

        return Math.random() < p ? 0 : 1;
    }

    public static int rand01() {
        int num = 0;
        do {
            num = rand01p();
        } while (num == rand01p());

        return num; // 随机产生0或者1
    }

    public static int rand0To3() {
        return 2 * rand01() + rand01();
    }

    /**
     * 生成1-6之间的随机数利用给定的概率函数
     * @return
     */
    public static int rand1To6() {
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();
        } while (num >= 12);
        // 现在num 取值在0 ~ 11之间
        return num % 6 + 1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

//    public static void main(String[] args) {
//        System.out.println(getTwoNumberMax公约数(12, 10));
//    }

    /**
     * 求两个数的最大公约数
     * @param n
     * @param m
     * @return
     */
    public static int getTwoNumberMax公约数(int m, int n) {
        // 采用辗转相除法
        return n == 0 ? m : getTwoNumberMax公约数(n, m % n);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

//    public static void main(String[] args) {
//        System.out.println(getNum的阶乘尾巴上有多少个0(20));
//        System.out.println(getNum的阶乘尾巴上有多少个0Best(20));
//    }

    /**
     * O(N*logN)
     * @param num
     * @return
     */
    public static int getNum的阶乘尾巴上有多少个0(int num) {
        if (num <= 0) {
            return 0;
        }
        int res = 0;
        int cur = 0;

        for (int i = 5; i < num + 1; i += 5) {
            cur = i;
            while (cur % 5 == 0) {
                res++;
                cur = cur / 5;
            }
        }
        return res;
    }

    public static int getNum的阶乘尾巴上有多少个0Best(int num) {
        // 思路，其实这一题是关于数论的，要看尾巴上有多少个0的话，应该分析，0是怎么产生的
        // 5! = 1 * 2 * 3 * 4 * 5 = 120 一个0
        // 可以看出来0是由2*5得到的，5!里面有3个2，一个5
        // 10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 3628800 2个0
        // 这里面有7个2，两个5，所以看出来，末尾的0是和5的个数密切相关的
        // 那么n!的5的个数就是答案，1 *...* 5 * ... * 10 * ... * 15 * ... * 20 * ... * 25 * ... * 30 * ...
        // 1 ~ 5, 6 ~ 10, 11 ~ 15, 16 ~ 20, 21 ~ 25 每5个数都有一个5，但是25特殊可以分成2个5
        // 超过了25之后，25 ～ 50 里面可以分成5的因子的数是25,30,35,40,45,50
        // 所以能产生5的因子的数是N/5 + N/25 + N/125 + ... + N/5^i (5^i <= N)
        if (num <= 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            res = res + num / 5;
            num = num / 5;
        }
        return res;
    }

    /**
     * @param num
     * @return
     */
    public static int calN阶乘二进制上末尾0的个数(int num) {
        if (num < 1) {
            return -1;
        }
        int res = 0;
        while (num != 0) {
            res += num / 2;
            num /= 2;
        }
        return res;
    }

}
