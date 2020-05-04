package main;

import java.io.File;
import java.util.Map;

public interface DataSender {

    boolean sendFile(File file, String filename, String tableName);

    boolean sendFiles(File file, Map<String, String> names);

}
