package com.javarush.task.task29.task2901;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * Рефакторинг в соответствии с Naming and Code Convention
 * Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга).
 *
 *
 * Requirements:
 * 1. Переименуй константу defaultFileName в соответствии с Naming and Code Convention.
 * 2. Переименуй метод getFileLoaded() в соответствии с Naming and Code Convention.
 * 3. Переименуй метод DownloadFileContent() в соответствии с Naming and Code Convention.
 * 4. Переименуй метод isexpectedline() в соответствии с Naming and Code Convention.
 * 5. Переименуй параметр expectedline метода принимающего String в соответствии с Naming and Code Convention.
*/

public class Solution {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/strange_file_name.tmp";

    private final String localFileName;
    private List<String> contentAsLines;
    private boolean isFileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public static void main(String[] args) {
        String fileName = Solution.class.getResource("Solution.java").getPath();

        Solution solution = new Solution(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasExpectedLine("public class Solution {"));   // Expected true
            System.out.println(solution.hasExpectedLine(" public class Solution {"));  // Expected false
        }
    }

    public boolean isFileLoaded() {
        return isFileLoaded;
    }

    public void downloadFileContent() {
        try {
            contentAsLines = Files.readAllLines((new File(localFileName)).toPath(), Charset.defaultCharset());
            isFileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasExpectedLine(String expectedLine) {
        return contentAsLines.contains(expectedLine);
    }
}
