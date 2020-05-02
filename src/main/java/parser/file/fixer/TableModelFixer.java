package parser.file.fixer;

import parser.file.reader.Reader;

import javax.swing.table.TableModel;

public interface TableModelFixer {

    TableModel fixTableModel(String filename, TableModel tableModel, Reader reader);

}
