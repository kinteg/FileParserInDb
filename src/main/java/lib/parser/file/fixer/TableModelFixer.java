package lib.parser.file.fixer;

import lib.common.model.TableModel;
import lib.parser.file.reader.Reader;

import java.io.File;

public interface TableModelFixer {

    TableModel fixTableModel(File file, Reader reader);

    TableModel fixTableModel(File file, TableModel tableModel, Reader reader);

}
