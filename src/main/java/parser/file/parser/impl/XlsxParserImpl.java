package parser.file.parser.impl;

import common.model.FullTableModel;
import common.model.TableModel;
import parser.file.parser.FileParser;
import parser.file.reader.Reader;

import java.io.File;
import java.util.List;

public class XlsxParserImpl implements FileParser {
    @Override
    public List<FullTableModel> getFullTable(List<File> files, long limit) {
        return null;
    }

    @Override
    public FullTableModel getFullTable(File file, long limit) {
        return null;
    }

    @Override
    public FullTableModel getFullTable(File file, long limit, TableModel tableModel) {
        return null;
    }

    @Override
    public Reader createReader(File file) {
        return null;
    }
}
