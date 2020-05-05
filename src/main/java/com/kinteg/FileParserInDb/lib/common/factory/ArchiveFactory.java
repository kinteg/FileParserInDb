package com.kinteg.FileParserInDb.lib.common.factory;

import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveParser;
import com.kinteg.FileParserInDb.lib.common.target.archive.ArchiveExtension;

public interface ArchiveFactory {

    ArchiveParser getArchiveParser(ArchiveExtension extension);

}
