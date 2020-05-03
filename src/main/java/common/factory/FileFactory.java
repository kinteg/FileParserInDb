package common.factory;

import common.target.file.FileExtension;
import parser.file.reader.Reader;

import java.io.File;

public interface FileFactory {

    Reader getFileReader(FileExtension extension, File file);

}
