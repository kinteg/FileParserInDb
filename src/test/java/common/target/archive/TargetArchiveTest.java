package common.target.archive;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetArchiveTest {

    private final TargetArchive targetArchive;

    public TargetArchiveTest() {
        this.targetArchive = new TargetArchiveImpl();
    }

    @Test
    public void isTargetArchive() {
        assertTrue(targetArchive.isTargetArchive("fdgr.zip"));
        assertTrue(targetArchive.isTargetArchive("fdgr.7z"));
        assertTrue(targetArchive.isTargetArchive("fdgr.tar"));
        assertFalse(targetArchive.isTargetArchive(""));
        assertFalse(targetArchive.isTargetArchive(null));
    }

    @Test
    public void getExtension() {
        assertEquals(ArchiveExtension.ZIP, targetArchive.getExtension("fdgr.zip"));
        assertEquals(ArchiveExtension.SEVEN_Z, targetArchive.getExtension("fdgr.7z"));
        assertEquals(ArchiveExtension.TAR, targetArchive.getExtension("fdgr.tar"));
        assertEquals(ArchiveExtension.NON_TARGET, targetArchive.getExtension(""));
        assertEquals(ArchiveExtension.NON_TARGET, targetArchive.getExtension(null));
    }
}