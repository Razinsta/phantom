package volta.ts.it.ProggettoPCTO.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static List<String> readTextFile(String filename) {
		List<String> result = null;
		
		try {
			Path path = Paths.get(filename);
			result = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
    }
}
