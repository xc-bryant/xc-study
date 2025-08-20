package com.xc.study.likou;

/**
 * 131题，现需要将一根长为正整数bamboo_len的竹子砍为若干段，
 * 每段长度均为正整数，请返回每段竹子长度的最大乘积是多少
 * 2<= bamboo_len <=58
 */
public class Task131 {
    public static void main(String[] args) {
        System.out.printf(String.valueOf(resolution(3)));
    }

    public static int resolution(int bamboo_len) {
        int max = 0;
        //里面数字个数
        for (int i = 2; i<=bamboo_len; i++) {
            int n = bamboo_len%i;
            int m = bamboo_len/i;
            //乘积
            int result = 1;
            //循环次数
            for (int j=0; j<i; j++) {
                int y = m;
                if (n > 0) {
                    y++;
                    n--;
                }
                result *= y;
            }
            max = Math.max(result, max);
        }
        return max;
    }
}
