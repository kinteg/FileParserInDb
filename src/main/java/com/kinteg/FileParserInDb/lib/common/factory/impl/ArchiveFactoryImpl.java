                package com.kinteg.FileParserInDb.lib.common.factory.impl;

import com.kinteg.FileParserInDb.lib.parser.archive.ArchiveParser;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.parser.ArchiveParserImpl;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.parser.SevenZParser;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.parser.TarParser;
import com.kinteg.FileParserInDb.lib.parser.archive.impl.parser.ZipParser;
import com.kinteg.FileParserInDb.lib.common.factory.ArchiveFactory;
import com.kinteg.FileParserInDb.lib.common.target.archive.ArchiveExtension;

                public class ArchiveFactoryImpl implements ArchiveFactory {

    @Override
    public ArchiveParser getArchiveParser(ArchiveExtension extension) {

        ArchiveParser archiveParser;

        switch (extension) {
            case TAR:
                archiveParser = new TarParser();
                break;

            case ZIP:
                archiveParser = new ZipParser();
                break;

            case SEVEN_Z:
                archiveParser = new SevenZParser();
                break;

            case NON_TARGET:
            default:
                archiveParser = new ArchiveParserImpl();
        }

        return archiveParser;
    }

}
