package common.factory;

import common.target.archive.ArchiveExtension;
import parser.archive.ArchiveParser;

public interface ArchiveFactory {

    ArchiveParser getArchiveParser(ArchiveExtension extension);

}
