package parser.file.fixer.impl;

import common.model.DataModel;
import common.model.TableModel;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.text.RandomStringGenerator;
import parser.file.fixer.ColumnCreator;
import parser.file.fixer.TableModelFixer;
import parser.file.fixer.TypeGenerator;
import parser.file.reader.Reader;
import validator.Validator;
import validator.impl.TableNameValidator;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class TableModelFixerImpl implements TableModelFixer {

    private static final int UPPER_LIMIT_VALUES = 15;

    private final Validator<String> tableNameValidator;
    private final RandomStringGenerator generator;
    private final ColumnCreator columnCreator;
    private final TypeGenerator typeGenerator;

    public TableModelFixerImpl() {
        tableNameValidator = new TableNameValidator();
        columnCreator = new ColumnCreatorImpl();
        typeGenerator = new TypeGeneratorImpl();

        generator = new RandomStringGenerator
                .Builder()
                .withinRange('a', 'z')
                .build();
    }

    @Override
    public TableModel fixTableModel(File file, TableModel tableModel, Reader reader) {
        fixModels(tableModel, reader);
        fixPrimaryKey(tableModel);
        fixTypes(tableModel, reader);
        fixFilename(tableModel, file);
        fixTableName(tableModel, file);

        return tableModel;
    }

    private void fixModels(TableModel tableModel, Reader reader) {
        if (tableModel.getModels() == null) {
            tableModel.setModels(getNamesColumn(reader));
        }
    }

    private List<DataModel> getNamesColumn(Reader reader) {
        List<String> nameColumns = reader.readNext();
        return columnCreator.createColumns(nameColumns);
    }

    private void fixPrimaryKey(TableModel tableModel) {
        if (tableModel.getPrimaryKey() == null && tableModel.getModels() != null) {
            tableModel.setPrimaryKey(getPrimaryKey(tableModel));
        }
    }

    private String getPrimaryKey(TableModel tableModel) {
        if (tableModel.getModels().stream().anyMatch(DataModel::isPrimary)) {
            return tableModel.getModels().stream().filter(DataModel::isPrimary).findFirst().get().getKey();

        } else {
            return tableModel.getModels().get(0).getKey();
        }
    }

    private void fixFilename(TableModel tableModel, File file) {
        if (tableModel.getTableName() == null) {
            tableModel.setFilename(file.getName());
        }
    }

    private void fixTableName(TableModel tableModel, File file) {
        String name = FilenameUtils.getBaseName(file.getAbsolutePath());

        if (tableNameValidator.isValid(name)) {
            tableModel.setTableName(name);
        } else {
            tableModel.setTableName(generator.generate(15));
        }
    }

    private void fixTypes(TableModel tableModel, Reader reader) {
        List<String> keys = getKeys(tableModel);
        List<Map<String, String>> values = createValues(keys, reader);
        List<String> types = createType(values);

        fixTypes(tableModel, types);
    }

    private List<String> getKeys(TableModel tableModel) {
        return tableModel.getModels()
                .stream().map(DataModel::getKey)
                .collect(Collectors.toList());
    }

    private List<Map<String, String>> createValues(List<String> keys, Reader reader) {
        List<String> nextRecordArray;
        List<Map<String, String>> values = new ArrayList<>();

        for (int j = 0; !(nextRecordArray = reader.readNext()).isEmpty() && j < UPPER_LIMIT_VALUES; j++) {
            Map<String, String> map = new LinkedHashMap<>();

            for (int i = 0; i < keys.size() && i < nextRecordArray.size(); i++) {
                map.put(keys.get(i), nextRecordArray.get(i));
            }

            values.add(map);
        }

        return values;
    }

    private List<String> createType(List<Map<String, String>> values) {
        List<String> types = new ArrayList<>();
        List<String> keys = new ArrayList<>(values.get(0).keySet());

        for (String key :
                keys) {
            List<String> column = new ArrayList<>();

            for (Map<String, String> row :
                    values) {
                column.add(row.get(key));
            }

            types.add(typeGenerator.getType(column));
        }


        return types;
    }

    private void fixTypes(TableModel tableModel, List<String> types) {
        for (int i = 0; i < tableModel.getModels().size() && i < types.size(); i++) {
            tableModel.getModels().get(i).setType(types.get(i));
        }
    }

}
