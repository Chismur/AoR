import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingm on 11.03.2018.
 */
public class Blocks {

    private String string;
    private String pattern;


    public Blocks(String string, String pattern) {
        this.string = string;
        this.pattern = pattern;
    }

    private int compare(String s, int i1, int i2) {
        long n = s.length();
        int eqLen = 0;
        while (i1 < n && i2 < n && s.charAt(i1++) == s.charAt(i2++)) {
            ++eqLen;
        }
        return eqLen;
    }


    private List<Integer> getBlocks(String s) {
        long n = s.length();
        int left = 0;
        int right = 0;
        List<Integer> blocks = new ArrayList<>();
        blocks.add(0, 0);
        for (int i = 1; i < n; ++i) {
            blocks.add(i, 0);
            if (i >= right) {
                blocks.add(i, compare(s, 0, i));
                left = i;
                right = i + blocks.get(i);
            } else {
                int j = i - left;
                if (blocks.get(j) < right - i) {
                    blocks.add(i, blocks.get(j));
                } else {
                    blocks.add(i, right - i + compare(s, right - i, right));
                    left = i;
                    right = left + blocks.get(i);
                }
            }
        }
        return blocks;
    }

    private List<Integer> getBlocksRes(List<Integer> blocks, int pLen) {
        int blockLen = blocks.size();
        List<Integer> blocksRes = new ArrayList<>();
        for (int i = pLen + 1; i < blockLen; i++) {
            if (blocks.get(i) == pLen) {
                blocksRes.add(i - pLen - 1);
            }
        }
        return blocksRes;
    }

    /**
     * Get Array of result
     *
     * @return List
     */
    public List<Integer> getResult() {

        //setString(s);
        //setPattern(p);

        return getBlocksRes(getBlocks(getString()), getPattern().length());
    }

    /**
     * Get String
     *
     * @return string
     */
    public String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

    /**
     * Get Pattern
     *
     * @return string
     */
    public String getPattern() {
        return pattern;
    }

    private void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
