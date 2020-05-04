package main;

import lib.common.model.FullTableModel;
import main.impl.CommonFileParserImpl;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CommonFileParserTest {

    private final CommonFileParser parser;

    public CommonFileParserTest() {
        parser = new CommonFileParserImpl();
    }

    @Test
    public void parseFile() {

        File file = new File("/home/kinteg/work/FileParserInDb/src/test/resources/testFiles/арабская ночь_1.zip");

        List<FullTableModel> fullTableModels = parser.parseFile(file, 15);

        System.out.println(fullTableModels);

    }

    @Test
    public void testParseFile() {
    }

}