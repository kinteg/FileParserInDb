package parser.file.fixer;

import common.model.DataModel;
import org.junit.Test;
import parser.file.fixer.impl.ColumnCreatorImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ColumnCreatorTest {

    private final ColumnCreator columnCreator;

    public ColumnCreatorTest() {
        columnCreator = new ColumnCreatorImpl();
    }

    @Test
    public void createColumnsCompletedTest() {

        List<String> nameColumns = Arrays.asList("column1", "column2", "column3", "column4", "column5");

        List<DataModel> verifiableDataModels = columnCreator.createColumns(nameColumns);
        List<DataModel> testDataModels = createDMInTest(nameColumns);

        assertEquals(verifiableDataModels, testDataModels);

    }

    private List<DataModel> createDMInTest(List<String> nameColumns) {
        List<DataModel> testDataModels = nameColumns.stream().map(DataModel::new).collect(Collectors.toList());

        testDataModels.get(0).setPrimary(true);

        return testDataModels;
    }

    @Test
    public void createColumnsFailedTest() {

        List<DataModel> verifiableDataModels = columnCreator.createColumns(null);
        List<DataModel> testDataModels = Collections.emptyList();

        assertEquals(verifiableDataModels, testDataModels);

    }

}