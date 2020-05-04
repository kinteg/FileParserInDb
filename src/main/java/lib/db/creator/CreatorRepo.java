package lib.db.creator;

import lib.common.model.TableModel;
import lib.common.model.TableModelStatus;

public interface CreatorRepo extends AutoCloseable {

    TableModelStatus createTable(TableModel tableModel);

}
