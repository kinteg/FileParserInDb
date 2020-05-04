package lib.common.factory;

import lib.common.target.archive.ArchiveExtension;
import lib.parser.archive.ArchiveParser;

public interface ArchiveFactory {

    ArchiveParser getArchiveParser(ArchiveExtension extension);

}
