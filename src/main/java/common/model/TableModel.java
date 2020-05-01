package common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TableModel {

    private String filename;
    private String tableName;
    private String primaryKey;
    private List<DataModel> models;

    public TableModel(String filename, String tableName, List<DataModel> models) {
        this.filename = filename;
        this.tableName = tableName;
        this.models = models;
    }

}
