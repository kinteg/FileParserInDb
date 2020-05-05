package com.kinteg.FileParserInDb.lib.parser.file.fixer;

import com.kinteg.FileParserInDb.lib.common.model.TableModel;
import com.kinteg.FileParserInDb.lib.parser.file.reader.Reader;

import java.io.File;

public interface TableModelFixer {

    TableModel fixTableModel(File file, Reader reader);

    TableModel fixTableModel(File file, TableModel tableModel, Reader reader);

}
