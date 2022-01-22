import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuilder builder = new StringBuilder();
        builder.append(reader.readLine());
        System.out.println(builder.reverse());
        reader.close();
    }
}