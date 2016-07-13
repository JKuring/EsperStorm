package esper.base.reader;

import java.io.BufferedReader;

public interface Readable {

    public BufferedReader read(String fileUri) throws Exception;

}
