package com.eastcom.reader;

import java.io.BufferedReader;

/**
 * Created by linghang.kong on 2016/7/19.
 */
public class ReaderController implements Readable {
    private Readable readable = new FtpReader();

    @Override
    public BufferedReader read(String fileUri) throws Exception {
        return this.readable.read(fileUri);
    }
}
