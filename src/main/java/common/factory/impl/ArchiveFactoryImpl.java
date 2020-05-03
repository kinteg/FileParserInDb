                package common.factory.impl;

import common.factory.ArchiveFactory;
import common.target.archive.ArchiveExtension;
import parser.archive.ArchiveParser;
import parser.archive.impl.ArchiveParserImpl;
import parser.archive.impl.SevenZParser;
import parser.archive.impl.TarParser;
import parser.archive.impl.ZipParser;

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
