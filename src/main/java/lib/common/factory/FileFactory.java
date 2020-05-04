package lib.common.factory;

import lib.common.target.file.FileExtension;
import lib.parser.file.reader.Reader;

import java.io.File;

public interface FileFactory {

    Reader getFileReader(FileExtension extension, File file);

}
