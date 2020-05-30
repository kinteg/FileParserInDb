package com.kinteg.FileParserInDb.lib.common.factory;

import com.kinteg.FileParserInDb.lib.common.target.archive.ArchiveExtension;
import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveParser;

public interface ArchiveFactory {

    ArchiveParser getArchiveParser(ArchiveExtension extension);

}
