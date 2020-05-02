package parser.file.parser.impl;

import common.model.FullTableModel;
import common.model.TableModel;
import parser.file.parser.FileParser;
import parser.file.reader.Reader;
import parser.file.reader.impl.ReaderImpl;

import java.io.File;

public class FileParserImpl implements FileParser {
    @Override
    public FullTableModel getFullTable(File file, long limit) {
        return FullTableModel.emptyFullTableModel();
    }

    @Override
    public FullTableModel getFullTable(File file, long limit, TableModel tableModel) {
        return FullTableModel.emptyFullTableModel();
    }

    @Override
    public Reader createReader(File file) {
        return new ReaderImpl();
    }
}
