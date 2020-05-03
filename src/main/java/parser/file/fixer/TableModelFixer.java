package parser.file.fixer;

import common.model.TableModel;
import parser.file.reader.Reader;

import java.io.File;

public interface TableModelFixer {

    TableModel fixTableModel(File file, TableModel tableModel, Reader reader);

}
