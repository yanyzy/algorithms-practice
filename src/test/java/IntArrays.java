/**
 * @author zhyee
 * @date 2018/10/18 下午6:13
 */
public class IntArrays {
    public static int[] newIntArrays(int a, int... res) {
        int[] ints = new int[res.length + 1];
        System.arraycopy(res, 0, ints, 1, res.length);
        ints[0] = a;
        return ints;
    }
}
