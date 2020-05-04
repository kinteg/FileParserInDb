package lib.parser.archive.impl.reader;

import lib.parser.archive.ArchiveReader;

import java.io.IOException;
import java.util.zip.ZipInputStream;

public class ZipInputStreamImpl implements ArchiveReader {

    private final ZipInputStream zipInputStream;

    public ZipInputStreamImpl(ZipInputStream zipInputStream) {
        this.zipInputStream = zipInputStream;
    }

    @Override
    public int read(byte[] buffer) {
        try {
            return zipInputStream.read(buffer);
        } catch (IOException e) {
            return -1;
        }
    }

    @Override
    public void close() throws IOException {
        zipInputStream.close();
    }

}
