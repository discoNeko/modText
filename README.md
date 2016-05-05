# sortText
tool / 主にtextファイルを対象にしたファイル内容のソート  
日本語(BOMなしUTF-8)で記述されたファイルを想定  

## install
>git clone https://github.com/discoNeko/sortText.git
cd ./sortText
  
## run
>javac -encoding UTF-8 sortText.java
java sortText [file name] [-options]
[options]
-sort : 改行区切りで重複を削除し,辞書順にソートする.
-(int) : ランダムな組み合わせを(int)回出力する.