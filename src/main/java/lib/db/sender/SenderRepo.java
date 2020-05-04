package lib.db.sender;

import lib.common.model.TableModel;
import lib.parser.file.reader.Reader;

public interface SenderRepo extends AutoCloseable {

    boolean insert(Reader reader, TableModel tableModel);

}
