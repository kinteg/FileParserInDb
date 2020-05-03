package main.impl;

import common.factory.ArchiveFactory;
import common.factory.FileFactory;
import common.factory.impl.ArchiveFactoryImpl;
import common.factory.impl.FileFactoryImpl;
import common.model.FullTableModel;
import common.target.archive.ArchiveExtension;
import common.target.archive.TargetArchive;
import common.target.archive.TargetArchiveImpl;
import common.target.file.FileExtension;
import common.target.file.TargetFile;
import common.target.file.TargetFileImpl;
import main.SimpleFileParser;
import parser.archive.ArchiveParser;
import parser.file.parser.FileParser;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleFileParserImpl implements SimpleFileParser {

    private final long CUSTOM_COLUMN_LIMIT = 5;

    private final TargetArchive targetArchive;
    private final TargetFile targetFile;
    private final ArchiveFactory archiveFactory;
    private final FileFactory fileFactory;

    public SimpleFileParserImpl() {
        targetArchive = new TargetArchiveImpl();
        archiveFactory = new ArchiveFactoryImpl();
        targetFile = new TargetFileImpl();
        fileFactory = new FileFactoryImpl();
    }

    @Override
    public List<FullTableModel> parseFile(File file) {
        return parseFile(file, CUSTOM_COLUMN_LIMIT);
    }

    @Override
    public List<FullTableModel> parseFile(File file, long limit) {

        List<File> files = unArchiveFiles(file);

        return parseFiles(files, limit);
    }

    private List<File> unArchiveFiles(File file) {
        List<File> files;

        if (targetArchive.isTargetArchive(file.getName())) {
            ArchiveExtension extension = targetArchive.getExtension(file.getName());
            files = getFiles(extension, file);

        } else {
            files = Collections.singletonList(file);
        }

        return files;
    }

    private List<File> getFiles(ArchiveExtension extension, File file) {
        List<File> files;

        try (ArchiveParser parser = archiveFactory.getArchiveParser(extension)) {
            files = parser.getFiles(file);

        } catch (Exception e) {
            files = Collections.emptyList();
        }

        return files;
    }

    private List<FullTableModel> parseFiles(List<File> files, long limit) {
        return files.stream().map(file -> parse(file, limit)).collect(Collectors.toList());
    }

    private FullTableModel parse(File file, long limit) {
        if (targetFile.isTargetFile(file.getName())) {
            FileExtension extension = targetFile.getExtension(file.getName());
            return parse(extension, file, limit);
        } else {
            return FullTableModel.emptyFullTableModel();
        }
    }

    private FullTableModel parse(FileExtension extension, File file, long limit) {
        FileParser fileParser = fileFactory.getFileParser(extension);
        return fileParser.getFullTable(file, limit);
    }

}
