import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Download {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File rootFile = new File(path);
        // 保存所有的目录
        Deque<File> dirStack = new LinkedList<>();
        if (rootFile.isDirectory()) {
            dirStack.offer(rootFile);
        }
        // 保存所有的sql
        List<String> sqlList = new LinkedList<>();
        String sqlTemplate = "insert into jav_downloaded(av_number) values ('%s');";
        while (!dirStack.isEmpty()) {
            File dirFile = dirStack.poll();
            File[] subFiles = dirFile.listFiles();
            if (subFiles == null || subFiles.length == 0) {
                continue;
            }
            for (int i = 0; i < subFiles.length; i++) {
                File file = subFiles[i];
                if (file.isDirectory()) {
                    dirStack.offer(file);
                } else {
                    String avFullName = file.getName();
                    if (avFullName.endsWith("mp4") || avFullName.endsWith("rmvb")
                            || avFullName.endsWith("avi") || avFullName.endsWith("wmv")) {
                        avFullName = avFullName.toLowerCase();
                        String reg = "[a-z]+-[0-9]+";
                        Pattern pattern = Pattern.compile(reg);
                        Matcher matcher = pattern.matcher(avFullName);
                        if (matcher.find()) {
                            String avNumber = matcher.group();
                            String sql = String.format(sqlTemplate, avNumber);
                            sqlList.add(sql);
                        }
                    }
                }
            }
        }
        if (!sqlList.isEmpty()) {
            String targetFilePath = path.endsWith("/") ? path + "av.sql" : path + "/av.sql";
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath));
                for (String sql : sqlList) {
                    writer.write(sql + "\r\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
