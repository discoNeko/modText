# sortText
tool / 主にtextファイルを対象にしたファイル内容のソート  
日本語(BOMなしUTF-8)で記述されたファイルを想定  
ANSIでエンコーディングされたファイルとして出力される

## install
>git clone https://github.com/discoNeko/sortText.git  
cd ./sortText  
  
## run
>javac -encoding UTF-8 sortText.java  
java sortText [file name] [-options]  
[options]  
-sort : 改行区切りで重複を削除し,辞書順にソートする.  
-(int) : ランダムな組み合わせを(int)回出力する.  

## example
>javac sortText word.txt sort  
  
カレントディレクトリ内にあるword.txtファイルの中身をソートする。  
ソート後、sorted_result.txtが出力される。  
  
>javac sortText word.txt 10  
  
カレントディレクトリ内にあるword.txtファイルの中身を改行区切りで読み込み、ランダムな組み合わせで単語を生成する。  
生成後、generated_result.txtが出力される。  
