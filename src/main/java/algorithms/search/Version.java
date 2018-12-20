package algorithms.search;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/11/8 下午4:55
 */

public class Version implements Comparable<Version> {
    private String versionNumber;

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public String toString() {
        return this.versionNumber;
    }

    @Override
    public int compareTo(Version o) {
        String[] a = versionNumber.split("\\.");
        String[] b = o.versionNumber.split("\\.");

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return Integer.valueOf(a[i]) - Integer.valueOf(b[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Version version1 = new Version();
        version1.setVersionNumber("115.1.1");

        Version version2 = new Version();
        version2.setVersionNumber("115.10.1");

        Version version3 = new Version();
        version3.setVersionNumber("0.0.0.2");

        Version version4 = new Version();
        version4.setVersionNumber("15.10.1");

        Version[] vs = new Version[]{version1, version2, version3, version4};
        Arrays.sort(vs);
        System.out.println(Arrays.toString(vs));
    }

}
