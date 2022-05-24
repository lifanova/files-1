import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Vera Lifanova
 * Date: 24.05.2022
 */

public class Main {
    public static final String ROOT_PATH = "C://Games";


    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        File rootDir = new File(ROOT_PATH);

        if (rootDir.mkdir()) {
             builder.append("[MAIN]: создан каталог Games").append("\n");
        }

        String path = rootDir.getAbsolutePath();

        // src, res, savegames, temp
        File srcDir = new File(path + "\\" + "src");
        File resDir = new File(path + "\\" + "res");
        File saveGamesDir = new File(path + "\\" + "savegames");
        File tempDir = new File(path + "\\" + "temp");

        if (srcDir.mkdir()) {
            builder.append("[MAIN]: создан каталог src").append("\n");
        }
        // main, test
        File mainDir = new File(srcDir.getAbsolutePath() + "\\" + "main");
        if (mainDir.mkdir()) {
            builder.append("[MAIN]: создан каталог main").append("\n");
        }

        try {
            File mainFile =  new File(mainDir.getAbsolutePath()+ "\\" + "Main.java");
            if(mainFile.createNewFile()) {
                builder.append("[MAIN]: создан файл Main.java").append("\n");
            }

            File utilsFile =  new File(mainDir.getAbsolutePath()+ "\\" + "Utils.java");
            if(utilsFile.createNewFile()) {
                builder.append("[MAIN]: создан файл Utils.java").append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File testDir = new File(srcDir.getAbsolutePath() + "\\" + "test");
        if (testDir.mkdir()) {
            builder.append("[MAIN]: создан каталог test").append("\n");
        }

        //
        if (resDir.mkdir()) {
            builder.append("[MAIN]: создан каталог res").append("\n");
        }

        File drawablesDir = new File(resDir.getAbsolutePath() + "\\" + "drawables");
        if (drawablesDir.mkdir()) {
            builder.append("[MAIN]: создан каталог drawables").append("\n");
        }

        File vectorsDir = new File(resDir.getAbsolutePath() + "\\" + "vectors");
        if (vectorsDir.mkdir()) {
            builder.append("[MAIN]: создан каталог vectors").append("\n");
        }

        File iconsDir = new File(resDir.getAbsolutePath() + "\\" + "icons");
        if (iconsDir.mkdir()) {
            builder.append("[MAIN]: создан каталог icons").append("\n");
        }

        //
        if (saveGamesDir.mkdir()) {
            builder.append("[MAIN]: создан каталог savegames").append("\n");
        }

        if (tempDir.mkdir()) {
            builder.append("[MAIN]: создан каталог temp").append("\n");
        }

        try {
            File tempFile =  new File(tempDir.getAbsolutePath()+ "\\" + "temp.txt");
            if(tempFile.createNewFile()) {
                builder.append("[MAIN]: создан файл temp.txt").append("\n");
            }

            FileWriter fileWriter = new FileWriter(tempFile);
            fileWriter.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(builder.toString());
    }
}
