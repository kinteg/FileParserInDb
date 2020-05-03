package common.factory.impl;

import common.factory.FileFactory;
import common.target.file.FileExtension;
import parser.file.parser.FileParser;
import parser.file.parser.impl.FileParserImpl;
import parser.file.parser.impl.XlsxParserImpl;
import parser.file.parser.impl.CsvParserImpl;
import parser.file.parser.impl.TxtParserImpl;

public class FileFactoryImpl implements FileFactory {

    @Override
    public FileParser getFileParser(FileExtension extension) {

        FileParser fileParser;

        switch (extension) {
            case CSV:
                fileParser = new CsvParserImpl();
                break;

            case TXT:
                fileParser = new TxtParserImpl();
                break;

            case XLSX:
                fileParser = new XlsxParserImpl();
                break;

            case NON_TARGET:
            default:
                fileParser = new FileParserImpl();
        }

        return fileParser;
    }

}
