                package lib.common.factory.impl;

import lib.common.factory.ArchiveFactory;
import lib.common.target.archive.ArchiveExtension;
import lib.parser.archive.ArchiveParser;
import lib.parser.archive.impl.parser.ArchiveParserImpl;
import lib.parser.archive.impl.parser.SevenZParser;
import lib.parser.archive.impl.parser.TarParser;
import lib.parser.archive.impl.parser.ZipParser;

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
