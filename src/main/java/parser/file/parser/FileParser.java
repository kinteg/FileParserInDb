package parser.file.parser;

import common.model.FullTableModel;
import common.model.TableModel;
import parser.file.reader.Reader;

import java.io.File;

public interface FileParser {

    FullTableModel getFullTable(File file, long limit);

    FullTableModel getFullTable(File file, long limit, TableModel tableModel);

    Reader createReader(File file);

}
