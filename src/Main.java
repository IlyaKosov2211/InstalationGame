import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        dirCreate("C://Games/src");
        dirCreate("C://Games/res");
        dirCreate("C://Games/savegames");
        dirCreate("C://Games/temp");
        dirCreate("C://Games/src/main");
        dirCreate("C://Games/src/test");
        fileCreate("C://Games/src/main/Main.java");
        fileCreate("C://Games/src/main/Utils.java");
        dirCreate("C://Games/res/drawables");
        dirCreate("C://Games/res/vectors");
        dirCreate("C://Games/res/icons");
        fileCreate("C://Games/temp/temp.txt");

        try (FileWriter writerLog = new FileWriter("C://Games/temp/temp.txt", false)){
            writerLog.write(String.valueOf(sb));
            writerLog.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void dirCreate(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            sb.append("Папка успешно создана " + path + "\n");
        } else {
            sb.append("Ошибка при создании папки " + path + "\n");
        }
    }

    public static void fileCreate(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                sb.append("Создан новый файл " + file + "\n");
            }
        } catch (IOException e) {
            sb.append("Ошибка при создании файла: " + file + "\n");
        }
    }
}