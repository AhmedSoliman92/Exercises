import java.io.*;
import java.util.concurrent.TimeUnit;

public class Parent {
    public static void main(String []args) throws IOException {
        Runtime runtime=Runtime.getRuntime();
        Process process=null;
        try {
            process=runtime.exec("java -cp C:\\User\\ahmed\\IdeaProjects\\Exercises\\out\\production\\Exercises; Child");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            process.waitFor(5,TimeUnit.SECONDS);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println("Writing...");
        OutputStream outputStream=process.getOutputStream();
        Writer writer= new OutputStreamWriter(outputStream);
        writer.write("Hello Echo!!\n");
        writer.flush();
        File file=new File("Parent.log");
        FileWriter fileWriter=new FileWriter(file);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        System.out.println("Reading...");
        InputStream inputStream=process.getInputStream();
        Reader reader= new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String line=bufferedReader.readLine();
        bufferedWriter.write(line);
        bufferedWriter.flush();
        while (line!=null) {
            System.out.println(line);
            bufferedWriter.write(line+'\n');
            bufferedWriter.flush();
            line = bufferedReader.readLine();
                if (!line.equals("Hello Echo!!")) {
                    if (Integer.parseInt(line) == 5) {
                        writer.write('*');
                        writer.flush();
                        System.out.println("Sent Message");
                    }
                }
            }
        process.destroy();
    }
}
