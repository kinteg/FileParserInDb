package com.kinteg.FileParserInDb.lib.parser.file.fixer.impl;

import com.kinteg.FileParserInDb.lib.common.model.DataModel;
import com.kinteg.FileParserInDb.lib.common.stringFixer.StringFixer;
import com.kinteg.FileParserInDb.lib.parser.file.fixer.ColumnCreator;
import com.kinteg.FileParserInDb.lib.validator.Validator;
import com.kinteg.FileParserInDb.lib.validator.impl.ColumnValidator;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ColumnCreatorImpl implements ColumnCreator {

    private final Validator<String> columnValidator;
    private final RandomStringGenerator generator;

    private static final String REPLACE_REGEX = "[./\\\\]";

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
        } else {
            name = name.replaceAll(REPLACE_REGEX, "");
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
