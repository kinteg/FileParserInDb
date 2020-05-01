package validator.impl;

import validator.ArchiveValidator;

public class ArchiveValidatorImpl implements ArchiveValidator {
    @Override
    public boolean isValidEntry(String filename, String name) {
        return false;
    }

    @Override
    public boolean isTargetFile(String filename) {
        return false;
    }

    @Override
    public boolean isTargetFile(String filename, String name) {
        return false;
    }
}
