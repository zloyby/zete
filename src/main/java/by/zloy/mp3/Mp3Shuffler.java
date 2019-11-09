package by.zloy.mp3;

import by.zloy.utils.PropertiesUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagConstant;
import org.farng.mp3.TagException;
import org.farng.mp3.TagOptionSingleton;
import org.farng.mp3.id3.ID3v1;

/**
 * Program to rename mp3 tags and files.
 * java -classpath ./target/classes;./lib/jid3lib/jars/jid3lib-0.5.4.jar by.zloy.mp3.Mp3Shuffler
 */
public class Mp3Shuffler {

    public static void main(String[] args) throws IOException, TagException {
        Mp3Shuffler mp3Shuffler = new Mp3Shuffler();
        mp3Shuffler.simpleShuffle();
    }

    private void simpleShuffle() throws IOException, TagException {
        TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);

        Properties properties = PropertiesUtil.loadProperties(
                "mp3shuffler.properties");
        String path = properties.getProperty("PATH");
        String predict = properties.getProperty("PREDICT");

        File dir = new File(path);
        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("Couldn't find any file.");
            return;
        } else {
            System.out.println("Founded " + files.length + " files.");
        }

        List<Integer> listOfRandomValues = createListOfNumbers(files.length);

        int counter = 0;
        for (File file : files) {
            String newPath = path + predict + listOfRandomValues.get(counter) + ".mp3";
            System.out.println(file.getAbsolutePath() + " to " + newPath);

            //Work with tags
            MP3File mp3File = new MP3File(file);
            removeAllOldTags(mp3File);
            createNewTag(predict, counter, mp3File);
            mp3File.save();

            //noinspection ResultOfMethodCallIgnored
            file.renameTo(new File(newPath));
            counter++;
        }
    }

    private void createNewTag(String predict, int i, MP3File mp3File) {
        ID3v1 id3v1 = new ID3v1();
        id3v1.setAlbum(predict);
        id3v1.setTitle(String.valueOf(i));
        mp3File.setID3v1Tag(id3v1);
    }

    private void removeAllOldTags(MP3File mp3File) throws IOException {
        if (mp3File.hasID3v1Tag()) {
            mp3File.delete(mp3File.getID3v1Tag());
        }
        if (mp3File.hasID3v2Tag()) {
            mp3File.delete(mp3File.getID3v2Tag());
        }
        if (mp3File.hasLyrics3Tag()) {
            mp3File.delete(mp3File.getLyrics3Tag());
        }
    }

    private List<Integer> createListOfNumbers(int size) {
        List<Integer> listOfRandomValues = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            listOfRandomValues.add(i);
        }
        Collections.shuffle(listOfRandomValues);
        return listOfRandomValues;
    }
}
