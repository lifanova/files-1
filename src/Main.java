import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vera Lifanova
 * Date: 24.05.2022
 */

public class Main {
    public static final String ROOT_PATH = "C:";
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        // Создаем Games
        File rootDir = createDir(ROOT_PATH, "Games");

        String path = rootDir.getAbsolutePath();
        // Создаем src и все вложенные папки и файлы
        createSrc(path);
        // Создаем res и все вложенные папки
        createRes(path);
        // Создаем savegames
        createSaveGames(path);
        // Создаем temp
        createTemp(path);

        System.out.println(builder.toString());
    }

    private static void createSrc(String path) {
        // Создаем src
        File srcDir = createDir(path, "src");

        // Создаем main и файлы Main.java, Utils.java
        File mainDir = createDir(srcDir.getAbsolutePath(), "main");
        createFile(mainDir.getAbsolutePath(), "Main.java");
        createFile(mainDir.getAbsolutePath(), "Utils.java");

        // Создаем test
        createDir(srcDir.getAbsolutePath(), "test");
    }

    private static void createRes(String path) {
        // Создаем res
        File resDir = createDir(path, "res");
        // Создаем drawables, vectors,icons
        createDir(resDir.getAbsolutePath(), "drawables");
        createDir(resDir.getAbsolutePath(), "vectors");
        createDir(resDir.getAbsolutePath(), "icons");
    }

    private static void createSaveGames(String path) {
        createDir(path, "savegames");
    }

    private static void createTemp(String path) {
        File tempDir = createDir(path, "temp");

        // Создаем temp.txt
        File tempFile = createFile(tempDir.getAbsolutePath(), "temp.txt");
        writeToFile(tempFile, builder.toString());
    }

    /**
     * Создание директории
     *
     * @param path - абсолютный путь к файлу
     * @param name - название создаваемого файла
     * @return File
     */
    private static File createDir(String path, String name) {
        String pathname = path + "\\" + name;

        File resultDir = new File(pathname);

        if (resultDir.mkdir()) {
            builder.append("[MAIN]: создан каталог ").append(name).append("\n");
        }

        return resultDir;
    }

    /**
     * Создание файла
     *
     * @param path     - абсолютный путь к файлу
     * @param filename - название создаваемого файла
     * @return File
     */
    private static File createFile(String path, String filename) {
        String pathname = path + "\\" + filename;

        File resultFile = null;
        try {
            resultFile = new File(pathname);
            if (resultFile.createNewFile()) {
                builder.append("[MAIN]: создан файл ").append(filename).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultFile;
    }

    /**
     * Запись произвольного текста в файл
     *
     * @param file - объект File, представляющий файл для записи
     * @param text - текст, записываемый в файл
     */
    private static void writeToFile(File file, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
