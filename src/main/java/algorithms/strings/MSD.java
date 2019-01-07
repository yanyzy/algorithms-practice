package algorithms.strings;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2019/1/6 下午9:30
 */
public class MSD {
    private static final int R = 256;
    private static final int M = 1;//小数组阈值（设置为1，暂不引入插入排序）
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);

    }

    public static void sort(String[] a, int lo, int hi, int d) {
        if (hi < lo + M) {
            //对小数组切换排序算法-插入排序
            return;
        }
        int[] count = new int[R + 2];
        //计算频率
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        //将频率转换为索引
        for (int i = 0; i < R + 1; i++) {
            count[i + 1] += count[i];
        }
        //数据分类
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        //回写
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"she",
                "sells",
                "seashells",
                "she",
                "by",
                "the"};
        MSD.sort(a);
        Assert.check(a[0].equals("by"));
        Assert.check(a[1].equals("seashells"));
        Assert.check(a[3].equals("she"));
        Assert.check(a[5].equals("the"));
    }

}
