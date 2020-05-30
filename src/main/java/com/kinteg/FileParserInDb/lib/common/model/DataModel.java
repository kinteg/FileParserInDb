package com.kinteg.FileParserInDb.lib.common.model;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DataModel {

    private String key;
    private String type;
    private boolean primary;

    public DataModel(String key) {
        this(key, "TEXT");
    }

    public DataModel(String key, String type) {
        this(key, type, false);
    }

    public DataModel(String key, boolean primary) {
        this(key, "TEXT", primary);
    }

    public static DataModel createEmptyDataModel() {
        return DataModel
                .builder()
                .key("")
                .type("")
                .primary(false)
                .build();
    }

}
