package reverse;

public class IntReverse {


    public int reverse(int x) {
        long temp = 0;

        while(x != 0){
            int pop = x % 10;
            temp = temp * 10 + pop;

            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)temp;
    }


    public static void main(String[] args) {

        IntReverse intReverse = new IntReverse();

       //System.out.println(intReverse.reverse(0x7fffffff));

        //-2147483648
       System.out.println(intReverse.reverse(0x80000000));
    }
}
