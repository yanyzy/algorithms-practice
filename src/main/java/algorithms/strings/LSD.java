package algorithms.strings;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2018/12/27 下午5:03
 */
public class LSD {
    void sort(String[] a, int w) {
        int length = a.length;
        int R = 256;
        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];
            //统计频率
            for (int j = 0; j < length; j++) {
                count[a[j].charAt(i) + 1]++;
            }
            //计算索引
            for (int j = 0; j < R; j++) {
                count[j + 1] += count[j];
            }
            String[] aux = new String[length];
            //按索引重排
            for (int j = 0; j < length; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }
            //回写
            for (int j = 0; j < length; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{
                "1ick750", "2iye230", "3cio720", "4pgc938", "3cio720", "1ick750", "2iye230", "2tye230"
        };
        new LSD().sort(strings, 6);
        Assert.check(strings[0].equals("1ick750"));
        Assert.check(strings[1].equals("1ick750"));
        Assert.check(strings[2].equals(strings[3]));
    }
}
