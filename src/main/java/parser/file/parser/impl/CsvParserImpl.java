package parser.file.parser.impl;

import com.opencsv.CSVReader;
import common.model.FullTableModel;
import common.model.TableModel;
import parser.file.fixer.TableModelFixer;
import parser.file.fixer.impl.TableModelFixerImpl;
import parser.file.parser.FileParser;
import parser.file.reader.Reader;
import parser.file.reader.impl.CsvReaderImpl;
import parser.file.reader.impl.ReaderImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CsvParserImpl implements FileParser {

    private final TableModelFixer tableModelFixer;

    public CsvParserImpl() {
        this.tableModelFixer = new TableModelFixerImpl();
    }

    @Override
    public FullTableModel getFullTable(File file, long limit) {
        return getFullTable(file, limit, new TableModel());
    }

    @Override
    public FullTableModel getFullTable(File file, long limit, TableModel tableModel) {
        return null;
    }

    @Override
    public Reader createReader(File file) {
        try {
            return new CsvReaderImpl(new CSVReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            return new ReaderImpl();
        }
    }
}
