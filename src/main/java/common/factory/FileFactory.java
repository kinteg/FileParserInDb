package common.factory;

import common.target.file.FileExtension;
import parser.file.parser.FileParser;

public interface FileFactory {

    FileParser getFileParser(FileExtension extension);

}
