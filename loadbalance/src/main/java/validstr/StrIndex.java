package validstr;

public class StrIndex {

    public int strStr(String haystack, String needle) {

        //haystack.contains(needle)

        if (needle.equals("")) {
            return 0;
        }

                int ret = haystack.indexOf(needle);

                return ret;
    }


    public static void main(String[] args) {
        StrIndex strIndex = new StrIndex();
        System.out.println(strIndex.strStr("a","a"));
    }
}
