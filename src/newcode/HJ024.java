package newcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 合唱队
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * @author: ZJY
 * @date: 2022/4/23 12:19 下午
 */
public class HJ024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] numsStr = scanner.nextLine().split("\\s+");
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        int[] upDp = new int[nums.length];
        Arrays.fill(upDp, 1);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1);
                }
            }
        }
        int[] downDp = new int[nums.length];
        Arrays.fill(downDp, 1);
        for (int i = count - 1; i >= 0; i--) {
            for (int j = count - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    downDp[i] = Math.max(downDp[i], downDp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < count; i++) {
            max = Math.max(upDp[i] + downDp[i], max);
        }
        System.out.println(count - max + 1);
    }
}
