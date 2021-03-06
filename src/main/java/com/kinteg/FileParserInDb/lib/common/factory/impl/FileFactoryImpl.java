package com.kinteg.FileParserInDb.lib.common.factory.impl;

import com.kinteg.FileParserInDb.lib.common.factory.FileFactory;
import com.kinteg.FileParserInDb.lib.common.target.file.FileExtension;
import com.kinteg.FileParserInDb.lib.parser.file.reader.Reader;
import com.kinteg.FileParserInDb.lib.parser.file.reader.impl.CsvReaderImpl;
import com.kinteg.FileParserInDb.lib.parser.file.reader.impl.ReaderImpl;
import com.kinteg.FileParserInDb.lib.parser.file.reader.impl.TxtReaderImpl;
import com.kinteg.FileParserInDb.lib.parser.file.reader.impl.XlsxReaderImpl;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFactoryImpl implements FileFactory {

    @Override
    public Reader getFileReader(FileExtension extension, File file) {

        Reader fileParser;

        switch (extension) {
            case CSV:
                fileParser = createCsvReader(file);
                break;

            case TXT:
                fileParser = createTxtReader(file);
                break;

            case XLSX:
                fileParser = createXlsxReader(file);
                break;

            case NON_TARGET:
            default:
                fileParser = new ReaderImpl();
        }

        return fileParser;
    }

    private Reader createCsvReader(File file) {
        try {
            return new CsvReaderImpl(new CSVReader(new FileReader(file)));
        } catch (IOException e) {
            return new ReaderImpl();
        }
    }

    private Reader createTxtReader(File file) {
        try {
            return new TxtReaderImpl(Files.newBufferedReader(
                    Paths.get(file.getAbsolutePath()),
                    Charset.forName("windows-1251")));
        } catch (IOException e) {
            return new ReaderImpl();
        }
    }

    private Reader createXlsxReader(File file) {
        try {
            return new XlsxReaderImpl(WorkbookFactory.create(file));
        } catch (IOException e) {
            return new ReaderImpl();
        }
    }

}
