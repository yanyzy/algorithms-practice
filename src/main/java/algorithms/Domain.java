package algorithms;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2018/11/8 下午6:40
 */
public class Domain implements Comparable<Domain> {

    private String domain;

    public Domain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "domain='" + domain + '\'' +
                '}';
    }

    @Override
    public int compareTo(Domain o) {
        String[] a = domain.split("\\.");
        String[] b = o.getDomain().split("\\.");
        for (int i = a.length - 1; i >= 0; i--) {
            if (!a[i].equals(b[i])) {
                return a[i].compareTo(b[i]);
            }
        }
        return 0;
    }
}

class DomainTest {
    public Domain[] sort(Domain[] domains) {
        for (int i = 0; i < domains.length; i++) {
            for (int j = 0; j < domains.length - i - 1; j++) {
                if (domains[j].compareTo(domains[j + 1]) > 0) {
                    Domain temp = domains[j];
                    domains[j] = domains[j + 1];
                    domains[j + 1] = temp;
                }
            }
        }
        return domains;
    }

    public static void main(String[] args) {
        Domain domain1 = new Domain("cs.test.edu");
        Domain domain2 = new Domain("cs.test.eda");
        Domain[] domains = new Domain[]{domain1,domain2};
        System.out.println(Arrays.toString(new DomainTest().sort(domains)));
    }
}
