import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author ZJY
 * @date 2019/3/11 19:04
 */
public class Leetcode047 {

    public static void main(String[] args) {
        Leetcode047 test = new Leetcode047();
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        permuteNums(nums, 0, nums.length - 1, result);
        return result;
    }

    public void permuteNums(int[] nums, int start, int end, List<List<Integer>> result) {
        if (start == end) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start + 1; i <= end; i++) {
            if (nums[start] == nums[i]) {
                continue;
            }
            swap(nums, start, i);
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

            permuteNums(nums, start + 1, end, result);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
