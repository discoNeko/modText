import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args){
    StringBuilder sb = new StringBuilder();
    if(args.length==0){
        sb.append("Usage: java Main [file name] [-options]").append("\n");
        sb.append("-sort : 改行区切りで重複を削除し,辞書順にソートする.").append("\n");
        sb.append("-(int) : ランダムな組み合わせを(int)回出力する.");
        System.out.println(sb);
        return;
    }
    if(args[1].equals("sort")){
      sort(args);
    }else if(Integer.parseInt(args[1])>0){
      gen(args);
    }else{
        sb.append("不明なエラー.");
        System.out.println(sb);
        return;
    }
  }

  public static void sort(String[] args){
    StringBuilder sb = new StringBuilder();
    try{
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      TreeSet<String> set = new TreeSet<String>();
      String str;
      while((str = br.readLine())!=null){
        set.add(str);
      }
      Iterator it = set.iterator();
      while (it.hasNext()) {
          sb.append(it.next()).append("\r\n");
      }
      FileWriter fw = new FileWriter(args[0], false);
      fw.write(sb.toString());
      fw.close();
    }catch(IOException e){
      System.out.println(e);
    }
  }

  public static void gen(String[] args){
    StringBuilder sb = new StringBuilder();
    try{
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      ArrayList<String> array = new ArrayList<String>();
      String str;
      while((str = br.readLine())!=null)
        array.add(str);
      int l = array.size();
      if(l==0){
        System.out.println("lack of data.");
        return;
      }
      Random rnd = new Random();
      int loop = Integer.parseInt(args[1]);
      for(int i = 0; i < loop; i++){
        int r1 = rnd.nextInt(l);
        int r2 = rnd.nextInt(l);
        int no = rnd.nextInt(4);
        if(r1==r2)r2=(r2+1)%l;
        if(no==0){
          System.out.println(array.get(r1)+"の"+array.get(r2));
          sb.append(array.get(r1)).append("の").append(array.get(r2)).append("\r\n");
        }else if(no<3 && array.get(r1).length()+array.get(r2).length()<5){
          int r3 = rnd.nextInt(l);
          while(r3==r1 || r3==r2){
            r3=(r3+1)%l;
          }
          if(array.get(r3).length()<5){
            System.out.println(array.get(r1)+array.get(r2)+"の"+array.get(r3));
            sb.append(array.get(r1)).append(array.get(r2)).append("の").append(array.get(r3)).append("\r\n");
          }else{
            System.out.println(array.get(r1)+array.get(r2)+array.get(r3));
            sb.append(array.get(r1)).append(array.get(r2)).append(array.get(r3)).append("\r\n");
          }
        }else{
          System.out.println(array.get(r1)+array.get(r2));
          sb.append(array.get(r1)).append(array.get(r2)).append("\r\n");
        }
      }
      sb.append("\r\n");
      FileWriter fw = new FileWriter("result.txt", true);
      fw.write(sb.toString());
      fw.close();
    }catch(IOException e){
      System.out.println(e);
    }
  }
}