/**
 * 罗马数字转整数
 * @author: ZJY
 * @date: 2019/2/1 下午7:22
 */
public class Leetcode013 {
    public int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) {
            return sum;
        }
        char[] numArr = s.toCharArray();
        for (int i = 0; i < numArr.length; i++) {
            char c = numArr[i];
            switch (c) {
                case 'I': {
                    if (i == numArr.length - 1) {
                        sum += 1;
                    } else {
                        if (numArr[i+1] == 'V') {
                            sum += 4;
                            i++;
                            break;
                        }
                        if (numArr[i+1] == 'X') {
                            sum += 9;
                            i++;
                            break;
                        }
                        sum += 1;
                    }
                    break;
                }
                case 'V': sum += 5;break;
                case 'X': {
                    if (i == numArr.length - 1) {
                        sum += 10;
                    } else {
                        if (numArr[i+1] == 'L') {
                            sum += 40;
                            i++;
                            break;
                        }
                        if (numArr[i+1] == 'C') {
                            sum += 90;
                            i++;
                            break;
                        }
                        sum += 10;
                    }
                    break;
                }
                case 'L': sum += 50;break;
                case 'C': {
                    if (i == numArr.length - 1) {
                        sum += 100;
                    } else {
                        if (numArr[i+1] == 'D') {
                            sum += 400;
                            i++;
                            break;
                        }
                        if (numArr[i+1] == 'M') {
                            sum += 900;
                            i++;
                            break;
                        }
                        sum += 100;
                    }
                    break;
                }
                case 'D': sum += 500;break;
                case 'M': sum += 1000;break;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Leetcode013 test = new Leetcode013();
        System.out.println(test.romanToInt("LVIII"));
    }
}
