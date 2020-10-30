package com.colin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

    public static String fileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        Path path = preLoadFile(filePath);

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            ExceptionUtils.throwRuntimeException(IllegalArgumentException.class, e, "Failed to load file: %s", filePath);
        }

        return contentBuilder.toString();
    }

    private static Path preLoadFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            return path;
        } else {
            LOG.debug("File {} not exist in Absolute Path, will check in CLASSPATH", filePath);
        }

        try {
            URL url = ClassLoader.getSystemResource(filePath);
            if (url != null) {
                path = Paths.get(url.toURI());
                return path;
            }
        } catch (URISyntaxException e) {
            LOG.debug("File {} not exist in CLASSPATH.", filePath);
        }

        ExceptionUtils.throwRuntimeException(IllegalStateException.class, null, "Failed to find file: %s", filePath);
        return null;
    }
}