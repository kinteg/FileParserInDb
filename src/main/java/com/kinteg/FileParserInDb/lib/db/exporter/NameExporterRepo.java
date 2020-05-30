package com.kinteg.FileParserInDb.lib.db.exporter;

import java.io.Closeable;
import java.util.List;

public interface NameExporterRepo extends Closeable {

    List<String> exportNames();

}
