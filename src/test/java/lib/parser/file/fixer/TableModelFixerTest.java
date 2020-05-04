package lib.parser.file.fixer;

import com.opencsv.CSVReader;
import lib.common.model.DataModel;
import lib.common.model.TableModel;
import org.junit.Test;
import lib.parser.file.fixer.impl.TableModelFixerImpl;
import lib.parser.file.reader.Reader;
import lib.parser.file.reader.impl.CsvReaderImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TableModelFixerTest {

    private Reader reader;
    private final TableModelFixer tableModelFixer;

    public TableModelFixerTest() {
        tableModelFixer = new TableModelFixerImpl();
    }

    @Test
    public void fixTableModel() throws FileNotFoundException {
        File file = new File("/home/kinteg/work/FileParserInDb/src/test/resources/testFiles/TestTableModelFixer.csv");
        reader = new CsvReaderImpl(new CSVReader(new FileReader(file)));

        TableModel verifiableDataModels = tableModelFixer.fixTableModel(file, new TableModel(), reader);
        TableModel testDataModels = createTableModel();

        assertEquals(verifiableDataModels, testDataModels);
    }

    private TableModel createTableModel() {
        String filename = "TestTableModelFixer.csv";
        String tableName = "TestTableModelFixer";
        String primaryKey = "column1.1";

        List<DataModel> dataModels = createDMInTest();

        return TableModel
                .builder()
                .filename(filename)
                .tableName(tableName)
                .primaryKey(primaryKey)
                .models(dataModels)
                .build();
    }

    private List<DataModel> createDMInTest() {
        List<String> nameColumns = Arrays.asList("column1.1, column1.2, column1.3, column1.4, column1.5".split(", "));

        List<DataModel> testDataModels = nameColumns.stream().map(DataModel::new).collect(Collectors.toList());

        DataModel dataModel1 = testDataModels.get(0);
        DataModel dataModel2 = testDataModels.get(1);
        DataModel dataModel3 = testDataModels.get(2);
        DataModel dataModel4 = testDataModels.get(3);
        DataModel dataModel5 = testDataModels.get(4);

        dataModel1.setType("integer");
        dataModel2.setType("double precision");
        dataModel3.setType("date");
        dataModel4.setType("time");
        dataModel5.setType("timestamp");

        testDataModels.set(0, dataModel1);
        testDataModels.set(1, dataModel2);
        testDataModels.set(2, dataModel3);
        testDataModels.set(3, dataModel4);
        testDataModels.set(4, dataModel5);

        testDataModels.get(0).setPrimary(true);

        return testDataModels;
    }
}