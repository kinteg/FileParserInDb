package com.kinteg.FileParserInDb.lib.validator;

public interface ArchiveValidator {

    boolean isValidEntry(String filename, String name);

    boolean isTargetFile(String filename);

    boolean isTargetFile(String filename, String name);

}
