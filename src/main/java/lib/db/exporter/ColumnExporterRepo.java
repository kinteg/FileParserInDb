package lib.db.exporter;

import lib.common.model.DataModel;

import java.io.Closeable;
import java.util.List;

public interface ColumnExporterRepo extends Closeable {

    List<DataModel> exportDataModel(String tableName);

}
