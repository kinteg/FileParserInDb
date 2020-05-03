package parser.file.parser.impl;

import common.model.FullTableModel;
import org.junit.Test;
import parser.file.parser.FileParser;

import java.io.File;

import static org.junit.Assert.*;

public class CsvParserImplTest {

    private final FileParser fileParser;

    public CsvParserImplTest() {
        fileParser = new CsvParserImpl();
    }

    @Test
    public void testGetFullTable1() {
    }

    @Test
    public void testGetFullTable2() {
        File file = new File("/home/kinteg/work/FileParserInDb/src/test/resources/testFiles/TestTableModelFixer.csv");

        FullTableModel fullTableModel = fileParser.getFullTable(file, 15);

        System.out.println(fullTableModel);
    }

    @Test
    public void testGetFullTable3() {
    }

    @Test
    public void createReader() {
    }
}