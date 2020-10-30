package com.colin.common;

import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void fileToString() {
        String filePath = "file/test-file.txt";
        System.out.println(FileUtils.fileToString(filePath));
    }
}