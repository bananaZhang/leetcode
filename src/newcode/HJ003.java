package newcode;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，
 * 然后再把这些数从小到大排序，按照排好的顺序输出。
 * 输入
 * 3
 * 2
 * 2
 * 1
 * @author: ZJY
 * @date: 2022/4/23 12:21 下午
 */
public class HJ003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            set.add(num);
        }
        for (Integer num : set) {
            System.out.println(num);
        }
    }
}
