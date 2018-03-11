import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingm on 11.03.2018.
 */
public class Pref {

    private String string;
    private String pattern;

    public Pref(String string, String pattern) {
        this.string = string;
        this.pattern = pattern;
    }

    /**
     * Get Prefix border array
     *
     * @param string
     * @return
     */
    private List<Integer> getBp(String string) {
        int n = string.length();
        int bpRight;
        List<Integer> bp = new ArrayList<>();
        bp.add(0, 0);
        for (int i = 1; i < n; i++) {
            bpRight = bp.get(i - 1);
            while (bpRight > 0 && string.charAt(i) != string.charAt(bpRight)) {
                bpRight = bp.get(bpRight - 1);
            }
            if (string.charAt(i) == string.charAt(bpRight)) {
                bp.add(i, bpRight + 1);
            } else {
                bp.add(i, 0);
            }
        }
        return bp;
    }


    /**
     * Creates array of results
     *
     * @param bp
     * @param pLen
     * @return
     */
    private List<Integer> getBpRes(List<Integer> bp, int pLen) {
        int bpLen = bp.size();
        List<Integer> bpRes = new ArrayList<>();
        for (int i = pLen + 1; i < bpLen; i++) {
            if (bp.get(i) == pLen) {
                bpRes.add(i - 2 * pLen);
            }
        }
        return bpRes;
    }

    public List<Integer> getResult() {

        //setString(s);
        //setPattern(p);

        return getBpRes(getBp(getString()), getPattern().length());
    }

    public String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

    public String getPattern() {
        return pattern;
    }

    private void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
