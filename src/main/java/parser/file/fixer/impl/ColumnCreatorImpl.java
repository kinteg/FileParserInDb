package parser.file.fixer.impl;

import common.model.DataModel;
import common.stringFixer.StringFixer;
import org.apache.commons.text.RandomStringGenerator;
import parser.file.fixer.ColumnCreator;
import validator.Validator;
import validator.impl.ColumnValidator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnCreatorImpl implements ColumnCreator {

    private final Validator<String> columnValidator;
    private final RandomStringGenerator generator;

    public ColumnCreatorImpl() {
        this.columnValidator = new ColumnValidator();
        this.generator = new RandomStringGenerator
                .Builder()
                .withinRange('a', 'z')
                .build();
    }

    @Override
    public List<DataModel> createColumns(List<String> nameColumns) {

        if (nameColumns == null) {
            return Collections.emptyList();
        }

        return makeDataModels(fixList(nameColumns));
    }

    private List<String> fixList(List<String> nameColumns) {
        nameColumns = StringFixer.fixStrings(nameColumns);

        nameColumns = fixNames(nameColumns);

        return nameColumns;
    }

    private List<String> fixNames(List<String> names) {
        return names.stream()
                .map(this::fixName)
                .collect(Collectors.toList());
    }

    private String fixName(String name) {
        if (!columnValidator.isValid(name)) {
            name = generator.generate(10);
        }

        return name;
    }

    private List<DataModel> makeDataModels(List<String> nameColumns) {
        List<DataModel> dataModels = nameColumns.stream()
                .map(DataModel::new).collect(Collectors.toList());

        if (!dataModels.isEmpty()) {
            dataModels.get(0).setPrimary(true);
        }

        return dataModels;
    }

}
