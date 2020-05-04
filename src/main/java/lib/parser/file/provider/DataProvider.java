package lib.parser.file.provider;

import lib.parser.file.reader.Reader;

import java.util.List;
import java.util.Map;

public interface DataProvider {

    List<Map<String, String>> getValues(Reader reader, List<String> keys, long limit);

}
