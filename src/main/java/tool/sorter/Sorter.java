package tool.sorter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sorter {

	public static final String SEPARATOR = "\t";

	public static void main(String[] args) throws IOException{
        int argsIndex = 0;
        Path SORT_CONDITION = Paths.get(args[argsIndex++]);
        Path INPUT = Paths.get(args[argsIndex++]);
        Path OUTPUT = Paths.get(args[argsIndex++]);

		// ソート対象ファイル読み込み。
		// ソート条件に引っかからなかった値は元の順序のまま出力したいのでLinkedHashMapを使用。
		Map<String,String> inputMap = new LinkedHashMap<String, String>();
		Files.lines(INPUT).forEach(
				line -> inputMap.put(line.split(SEPARATOR)[0], line));

		try(BufferedWriter writer = Files.newBufferedWriter(OUTPUT, StandardOpenOption.CREATE)){

			// ソート条件ファイルの順に結果ファイルに書き込む。
			Files.readAllLines(SORT_CONDITION).forEach( key -> {
				try {
					if(inputMap.containsKey(key)){
						writer.write(inputMap.get(key) + System.lineSeparator());
						// 出力した値は消す。
						inputMap.remove(key);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			// 残っている値を出力。
			inputMap.values().forEach( value -> {
				try {
					writer.write(value + System.lineSeparator());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}


	}
}