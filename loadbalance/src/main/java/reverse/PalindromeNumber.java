package reverse;

public class PalindromeNumber {


    public boolean isPalindrome(int x) {

        int globalX = x;

        int res = x % 10;
        if (res == 0) {
            return true;
        }

        int tmp = 0;

        while (x != 0) {
            int pos = x % 10;
            tmp = tmp * 10 + pos;
            x /= 10;
        }

        if (globalX == tmp) {
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        System.out.println(palindromeNumber.isPalindrome(121));

    }
}
