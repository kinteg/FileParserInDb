package parser.file.reader.impl;

import parser.file.reader.Reader;

import java.util.Collections;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public String readLine() {
        return "";
    }

    @Override
    public List<String> readNext() {
        return Collections.emptyList();
    }

    @Override
    public void close() throws Exception {

    }
}
