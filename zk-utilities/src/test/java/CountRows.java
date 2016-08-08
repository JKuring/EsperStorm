import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/8.
 */
public class CountRows {
    private long rows = 0L;
    private long chars = 0L;
    private long fileNum = 0L;
    private String fileType = "java";

    public static void main(String[] args) throws IOException {
        String path = args[0];
        String fileType = args[1];
        CountRows countRows = new CountRows();
        countRows.setFileType(fileType);
        System.out.println("开始计算目录 " + path + " 下文件的总行数...");
        countRows.countRows(path);
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void countRows(String path) throws IOException {
        File file = new File(path);
        getAllFile(file);
        System.out.println("统计文件数：" + this.fileNum);
        System.out.println("总字符数：" + this.chars + "个");
        System.out.println("总行数为：" + this.rows + " 行");
    }

    private void getAllFile(File file) throws IOException {
        File[] files = file.listFiles();
        for (File tmp : files
                ) {
            String fileName = tmp.getName();
            if (tmp.isFile() && fileName.endsWith(this.fileType)) {
                long chars = tmp.length();
                //System.out.println("文件名称：" + fileName);
                //System.out.println("文件字符数：" + chars);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(tmp));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    //按照编码规范剔除空行和注释行
                    //if (!line.trim().equals("")) {
                    //    if(!line.trim().startsWith("/**") &&
                    //            !line.trim().startsWith("*") &&
                    //            !line.trim().startsWith("*/") &&
                    //            !line.trim().startsWith("//")) {
                    //        this.rows++;
                    //    }
                    //}
                    this.rows++;
                }
                this.chars += chars;
                this.fileNum++;
            } else if (tmp.isDirectory()) {
                getAllFile(tmp);
            }
        }
    }
}
