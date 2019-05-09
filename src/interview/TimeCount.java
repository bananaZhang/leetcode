package interview;

/**
 * @author ZJY
 * @ClassName: TimeCount
 * @Description: TimeCount
 * @date 2019/5/9 10:39
 */
public class TimeCount {

    public static void main(String[] args) {
        System.out.println(strangeCounter(50));
    }

    private static long strangeCounter(long t) {
        if (t <= 3) {
            return t;
        }
        int count = 0;
        int i = 1;// 判断是递增还是递减
        int sum = 3;
        for (; sum < t; sum *= 2) {
            i ++;
            count += sum;
        }
        count -= sum;
        i --;
        if ((i & 1) == 1) {
            return t - count;
        } else {
            return 3 * i - (t - count);
        }
    }
}
