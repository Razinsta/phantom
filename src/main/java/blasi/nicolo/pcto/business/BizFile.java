package blasi.nicolo.pcto.business;

import java.util.List;

import volta.ts.it.ProggettoPCTO.util.FileUtil;

public class BizFile {

	public static List<String> readTextFile(String filename) {
		List<String> list = FileUtil.readTextFile(filename);
		return list;
	}
}
