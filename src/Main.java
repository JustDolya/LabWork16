import java.io.*;
import  java.util.regex.Pattern;
import  java.util.regex.Matcher;


public class Main {
    public static void main(String[] args) {
        Pattern simpleComm = Pattern.compile("//.*\n");
        Pattern complexComm = Pattern.compile("/\\*(.|\\n)*?\\*/");
        try(BufferedReader br = new BufferedReader(new FileReader("src/program.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/newProgram.txt"))){
            StringBuilder sb = new StringBuilder();
            String str;
            while((str=br.readLine()) != null) {
                sb.append(str).append("\n");
            }
            String content = sb.toString();
            Matcher matcherSimple = simpleComm.matcher(content);
            String preResult = matcherSimple.replaceAll("\n");
            Matcher matcherComplex = complexComm.matcher(preResult);
            String result = matcherComplex.replaceAll("");
            bw.write(result);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}