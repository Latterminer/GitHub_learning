package interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCount {
    public Integer stringCounter(String fileString, String dstString) {
        Pattern pattern = Pattern.compile(dstString);
        Matcher matcher = pattern.matcher(fileString);
        int result = 0;
        while(matcher.find()){
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            FileReader fileReader = new FileReader("F:\\WorkSpace\\learning\\base\\src\\main\\resources\\words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                stringBuffer.append(str);
            }
            StringCount stringCount = new StringCount();
            Integer result = stringCount.stringCounter(stringBuffer.toString(), "ssfdf");
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done!");
        }


    }
}
