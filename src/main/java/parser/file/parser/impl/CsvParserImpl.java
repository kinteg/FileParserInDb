package parser.file.parser.impl;

import com.opencsv.CSVReader;
import common.model.DataModel;
import common.model.FullTableModel;
import common.model.TableModel;
import parser.file.fixer.TableModelFixer;
import parser.file.fixer.impl.TableModelFixerImpl;
import parser.file.parser.FileParser;
import parser.file.provider.DataProvider;
import parser.file.provider.impl.DataProviderImpl;
import parser.file.reader.Reader;
import parser.file.reader.impl.CsvReaderImpl;
import parser.file.reader.impl.ReaderImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvParserImpl implements FileParser {

    private final TableModelFixer tableModelFixer;
    private final DataProvider provider;

    public CsvParserImpl() {
        this.tableModelFixer = new TableModelFixerImpl();
        provider = new DataProviderImpl();
    }

    @Override
    public List<FullTableModel> getFullTable(List<File> files, long limit) {
        return files.stream()
                .map(file -> getFullTable(file, limit))
                .collect(Collectors.toList());
    }

    @Override
    public FullTableModel getFullTable(File file, long limit) {
        return getFullTable(file, limit, new TableModel());
    }

    @Override
    public FullTableModel getFullTable(File file, long limit, TableModel tableModel) {
        fixTableModel(file, tableModel);
        List<Map<String, String>> values = getValues(file, limit, tableModel);

        return FullTableModel
                .builder()
                .tableModel(tableModel)
                .values(values)
                .build();
    }

    private void fixTableModel(File file, TableModel tableModel) {
        Reader reader = createReader(file);
        tableModelFixer.fixTableModel(file, tableModel, reader);
    }

    private List<Map<String, String>> getValues(File file, long limit, TableModel tableModel) {
        Reader reader = createReader(file);
        List<String> keys = getKeys(tableModel);

        return provider.getValues(reader, keys, limit);
    }

    private List<String> getKeys(TableModel tableModel) {
        return tableModel.getModels().stream()
                .map(DataModel::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Reader createReader(File file) {
        try {
            return new CsvReaderImpl(new CSVReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            return new ReaderImpl();
        }
    }
}
