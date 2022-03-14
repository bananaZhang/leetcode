import java.util.*;

public class Practice {

    private List<String> resultList = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private Map<String, List<String>> map = buildMap();

    public List<String> letterCombinations(String digits) {
        backtrack(digits, 0);
        return resultList;
    }

    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            resultList.add(sb.toString());
            return;
        }
        List<String> strs = map.get(Character.toString(digits.charAt(index)));
        for (String str : strs) {
            sb.append(str);
            backtrack(digits, index + 1);
            sb.deleteCharAt(index);
        }
    }

    private Map<String, List<String>> buildMap() {
        Map<String, List<String>> table = new HashMap<>();
        table.put("2", Arrays.asList("a", "b", "c"));
        table.put("3", Arrays.asList("d", "e", "f"));
        table.put("4", Arrays.asList("g", "h", "i"));
        table.put("5", Arrays.asList("j", "k", "l"));
        table.put("6", Arrays.asList("m", "n", "o"));
        table.put("7", Arrays.asList("p", "q", "r", "s"));
        table.put("8", Arrays.asList("t", "u", "v"));
        table.put("9", Arrays.asList("w", "x", "y", "z"));
        return table;
    }

    public static void main(String[] args) {
        List<String> ss = new Practice().letterCombinations("23");
        System.out.println(ss);

    }
}
