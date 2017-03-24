package org.plugface.demo.plugins.countwords;

import org.plugface.DefaultPlugin;

import java.io.*;
import java.util.StringTokenizer;

public class CountWordsPlugin extends DefaultPlugin<Object, Long>{
    private static final String DELIMITERS = " -.,:;!?";

    public CountWordsPlugin() {
        super("countWordsPlugin");
    }

    public void start() {

    }

    public void stop() {

    }

    /**
     * This method return the number of words of a String or File Object
     * */
    public Long execute(Object object) {
        if (object instanceof File)
            return executeFile((File) object);
        else if (object instanceof String)
            return executeString((String) object);
        else
            return null;
    }
    /**
     * This method return the number of words in a txt file
     * */
    private Long executeFile(File fileToRead) {
        String line;
        long wordCounter=0;
        try{
            FileReader fileStream = new FileReader( fileToRead );
            BufferedReader bufferedReader = new BufferedReader( fileStream );
            while ((line=bufferedReader.readLine())!=null)
                wordCounter += executeString(line);
        } catch ( FileNotFoundException ignored) {
        } catch ( IOException ignored) {
        }
        return wordCounter;
    }
    /**
     * This method return the number of words of a String
     * */
    private Long executeString (String text) {
        return (long) new StringTokenizer(text, DELIMITERS).countTokens();
    }
}
