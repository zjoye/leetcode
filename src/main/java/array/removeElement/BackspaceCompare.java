package array.removeElement;

public class BackspaceCompare {
    public static void main(String[] args) {
        boolean result = backspaceCompare("ab#c", "ad#c");
        System.out.println(result);
    }

    public static boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0) {
                char sValue = s.charAt(sIndex);
                if (sValue == '#') {
                    sSkip++;
                    sIndex--;
                } else if (sSkip > 0) {
                    sSkip--;
                    sIndex--;
                } else {
                    break;
                }
            }
            while (tIndex >= 0) {
                char tValue = t.charAt(tIndex);
                if (tValue == '#') {
                    tSkip++;
                    tIndex--;
                } else if (tSkip > 0) {
                    tSkip--;
                    tIndex--;
                } else {
                    break;
                }
            }
            if (sIndex >= 0 && tIndex >= 0) {
                if (s.charAt(sIndex) != t.charAt(tIndex)) {
                    return false;
                }
            } else {
                if (sIndex >= 0 || tIndex >= 0) {
                    return false;
                }
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }
}
