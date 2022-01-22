import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String words = reader.readLine();
        reader.close();
        System.out.println(words);
        if (words.isEmpty()){
            System.out.println(0);
        }else{
            String[] Allwords = words.split("\\s+");
            System.out.println(Allwords.length);
        }

    }
}