package com.kinteg.FileParserInDb.lib.db.sender;

import com.kinteg.FileParserInDb.lib.common.model.TableModel;
import com.kinteg.FileParserInDb.lib.parser.file.reader.Reader;

public interface SenderRepo extends AutoCloseable {

    boolean insert(Reader reader, TableModel tableModel);

}
