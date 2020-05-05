package com.kinteg.FileParserInDb.lib.common.factory;

import com.kinteg.FileParserInDb.lib.parser.file.reader.Reader;
import com.kinteg.FileParserInDb.lib.common.target.file.FileExtension;

import java.io.File;

public interface FileFactory {

    Reader getFileReader(FileExtension extension, File file);

}
