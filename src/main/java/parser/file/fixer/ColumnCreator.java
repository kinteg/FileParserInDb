package parser.file.fixer;

import common.model.DataModel;

import java.util.List;

public interface ColumnCreator {

    List<DataModel> createColumns(List<String> nameColumns);

}
