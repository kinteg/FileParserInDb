package com.kinteg.FileParserInDb.lib.parser.archive.impl.parser;

import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveHelper;
import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveParser;
import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveReader;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.reader.ArchiveHelperImpl;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.reader.TarArchiveInputStreamImpl;
import com.kinteg.FileParserInDb.lib.validator.ArchiveValidator;
import com.kinteg.FileParserInDb.lib.validator.impl.ArchiveValidatorImpl;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TarParser implements ArchiveParser {

    private TarArchiveInputStream zis;
    private final ArchiveValidator archiveValidator;

    public TarParser() {
        archiveValidator = new ArchiveValidatorImpl();
    }

    @Override
    public File getFile(File zip, String name) {
        try {
            return unzipFile(zip, name);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public List<File> getFiles(File zip) {
        try {
            return unzipFiles(zip);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private File unzipFile(File zip, String name) throws IOException {
        zis = new TarArchiveInputStream(new FileInputStream(zip));

        TarArchiveEntry tarEntry;
        while ((tarEntry = zis.getNextTarEntry()) != null) {
            if (archiveValidator.isValidEntry(tarEntry.getName(), name)) {
                return getFile(tarEntry.getName(), zis);
            }
        }

        return null;
    }

    private List<File> unzipFiles(File zip) throws IOException {
        List<File> files = new ArrayList<>();

        zis = new TarArchiveInputStream(new FileInputStream(zip));

        TarArchiveEntry tarEntry;

        while ((tarEntry = zis.getNextTarEntry()) != null) {
            if (archiveValidator.isTargetFile(tarEntry.getName())) {
                files.add(getFile(tarEntry.getName(), zis));
            }
        }

        return files;
    }

    private File getFile(String name, TarArchiveInputStream zis) {
        ArchiveReader reader = new TarArchiveInputStreamImpl(zis);
        ArchiveHelper<ArchiveReader> helper = new ArchiveHelperImpl<>();

        return helper.createFile(name, reader);
    }

    @Override
    public void close() throws Exception {
        zis.close();
    }

}
