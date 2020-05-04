package lib.common.target.file;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetFileTest {

    private final TargetFile targetFile;

    public TargetFileTest() {
        targetFile = new TargetFileImpl();
    }

    @Test
    public void isTargetFile() {
        assertTrue(targetFile.isTargetFile("fdgr.csv"));
        assertTrue(targetFile.isTargetFile("fdgr.txt"));
        assertTrue(targetFile.isTargetFile("fdgr.xlsx"));
        assertFalse(targetFile.isTargetFile(""));
        assertFalse(targetFile.isTargetFile(null));
    }

    @Test
    public void getExtension() {
        assertEquals(FileExtension.CSV, targetFile.getExtension("fdgr.csv"));
        assertEquals(FileExtension.TXT, targetFile.getExtension("fdgr.txt"));
        assertEquals(FileExtension.XLSX, targetFile.getExtension("fdgr.xlsx"));
        assertEquals(FileExtension.NON_TARGET, targetFile.getExtension(""));
        assertEquals(FileExtension.NON_TARGET, targetFile.getExtension(null));
    }
}