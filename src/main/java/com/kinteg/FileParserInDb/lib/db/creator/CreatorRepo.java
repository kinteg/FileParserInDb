package com.kinteg.FileParserInDb.lib.db.creator;

import com.kinteg.FileParserInDb.lib.common.model.TableModel;
import com.kinteg.FileParserInDb.lib.common.model.TableModelStatus;

public interface CreatorRepo extends AutoCloseable {

    TableModelStatus createTable(TableModel tableModel);

}
