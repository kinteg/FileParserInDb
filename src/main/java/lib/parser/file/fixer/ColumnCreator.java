package lib.parser.file.fixer;

import lib.common.model.DataModel;

import java.util.List;

public interface ColumnCreator {

    List<DataModel> createColumns(List<String> nameColumns);

}
