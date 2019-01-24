package algorithms.strings;

/**
 * The type Brute.
 *
 * @author zhyee
 * @date 2019 /1/24 下午5:21
 */
public class Brute {

    public int search(String pat, String txt) {
        int N = pat.length();
        int M = txt.length();

        for (int i = 0; i <= M - N; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }
            if (j == N) {
                return i;
            }
        }
        return M;
    }

    public static void main(String[] args) {
        System.out.println(new Brute().search("xyz", "wixfjnxyzsbfx"));
    }

}

