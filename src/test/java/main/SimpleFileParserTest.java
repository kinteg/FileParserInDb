package main;

import common.model.FullTableModel;
import main.impl.SimpleFileParserImpl;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleFileParserTest {

    private final SimpleFileParser parser;

    public SimpleFileParserTest() {
        parser = new SimpleFileParserImpl();
    }

    @Test
    public void parseFile() {

        File file = new File("/home/kinteg/work/FileParserInDb/src/test/resources/testFiles/TestXlsxReaderImpl.txt");

        List<FullTableModel> fullTableModels = parser.parseFile(file);

        System.out.println(fullTableModels);

    }

    @Test
    public void testParseFile() {
    }

}