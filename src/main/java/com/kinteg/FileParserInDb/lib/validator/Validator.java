package com.kinteg.FileParserInDb.lib.validator;

public interface Validator<T> {

    boolean isValid(T name);

}
