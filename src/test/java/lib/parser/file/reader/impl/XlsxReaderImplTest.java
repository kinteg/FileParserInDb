package lib.parser.file.reader.impl;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import lib.parser.file.reader.Reader;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class XlsxReaderImplTest {

    @Test
    public void readLine() {
    }

    @Test
    public void readNext() throws Exception {
        Workbook xlsxReader = WorkbookFactory.create(new File("/home/kinteg/work/FileParserInDb/src/test/resources/testFiles/TestXlsxReaderImpl.xlsx"));
        Reader reader = new XlsxReaderImpl(xlsxReader);

        assertEquals(reader.readNext(), Arrays.asList("column1.1>column1.2>column1.3>column1.4>column1.5".split(">")));
        assertEquals(reader.readNext(), Arrays.asList("column2.1>column2.2>column2.3>column2.4>column2.5".split(">")));
        assertEquals(reader.readNext(), Arrays.asList("column3.1>column3.2>column3.3>column3.4>column3.5".split(">")));
        assertEquals(reader.readNext(), Arrays.asList("column5.1>column5.2>column5.3>column5.4>column5.5".split(">")));
        assertEquals(reader.readNext(), Collections.emptyList());

        reader.close();
    }

    @Test
    public void close() {
    }
}