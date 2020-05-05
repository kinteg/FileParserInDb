package com.kinteg.FileParserInDb.lib.validator.impl;

import com.kinteg.FileParserInDb.lib.common.target.file.TargetFile;
import com.kinteg.FileParserInDb.lib.common.target.file.TargetFileImpl;
import com.kinteg.FileParserInDb.lib.validator.ArchiveValidator;

public class ArchiveValidatorImpl implements ArchiveValidator {

    private final TargetFile targetFile;

    public ArchiveValidatorImpl() {
        targetFile = new TargetFileImpl();
    }

    @Override
    public boolean isValidEntry(String filename, String name) {
        return isTargetFile(filename) &&
                isTargetFile(filename, name);
    }

    @Override
    public boolean isTargetFile(String filename) {
        return targetFile.isTargetFile(filename.toLowerCase());
    }

    @Override
    public boolean isTargetFile(String filename, String name) {
        return filename.toLowerCase().equals(name.toLowerCase());
    }
}
