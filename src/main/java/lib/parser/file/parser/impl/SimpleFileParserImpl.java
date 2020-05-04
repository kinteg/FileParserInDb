package lib.parser.file.parser.impl;

import lib.common.factory.FileFactory;
import lib.common.factory.impl.FileFactoryImpl;
import lib.common.model.TableModel;
import lib.common.target.file.FileExtension;
import lib.common.target.file.TargetFile;
import lib.common.target.file.TargetFileImpl;
import lib.parser.file.fixer.TableModelFixer;
import lib.parser.file.fixer.impl.TableModelFixerImpl;
import lib.parser.file.parser.SimpleFileParser;
import lib.parser.file.reader.Reader;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleFileParserImpl implements SimpleFileParser {

    private final TableModelFixer tableModelFixer;
    private final FileFactory fileFactory;
    private final TargetFile targetFile;

    public SimpleFileParserImpl() {
        this.tableModelFixer = new TableModelFixerImpl();
        fileFactory = new FileFactoryImpl();
        targetFile = new TargetFileImpl();
    }

    @Override
    public List<TableModel> getFullTable(List<File> files) {
        return files.stream()
                .map(this::getFullTable)
                .collect(Collectors.toList());
    }

    @Override
    public TableModel getFullTable(File file) {
        return fixTableModel(file);
    }

    private TableModel fixTableModel(File file) {
        Reader reader = createReader(file);
        return tableModelFixer.fixTableModel(file, reader);
    }

    private Reader createReader(File file) {
        FileExtension extension = targetFile.getExtension(file.getName());
        return fileFactory.getFileReader(extension, file);
    }
}
