# Sorter_forMaven
[Sorter](https://github.com/SampleUser0001/Sorter)のMaven版

## 実行

``` sh
mvn clean compile exec:java -Dexec.mainClass="tool.sorter.Sorter" -Dexec.args="'${ソートキーファイル}' '${入力ファイルパス}' '${出力ファイルパス}'"
```

``` sh
mvn clean compile exec:java -Dexec.mainClass="tool.sorter.Sorter" -Dexec.args="'`pwd`/files/sort.txt' '`pwd`/files/input.tsv' '`pwd`/files/output.tsv'"
```