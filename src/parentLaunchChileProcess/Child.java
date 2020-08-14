package parentLaunchChileProcess;

import java.io.*;

import static java.lang.Thread.sleep;

public class Child {
    public static void main(String []args) throws IOException, InterruptedException {
        int c;
        System.out.println("Let's Echo: ");
        while((c=System.in.read())!='\n'){
            System.out.print((char)c);
        }
        File file=new File("res/childProcess.txt");
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        System.out.println();
         int counter = 0;
            while (counter <= 10) {
                System.out.println(counter++);
                bufferedWriter.write(counter+'\n');
                bufferedWriter.flush();
                sleep(1000);
                if (System.in.available() > 0) {
                    c = System.in.read();
                    if (c == '*') {
                        counter = 0;
                    }
                }
            }
            bufferedWriter.close();
    }
}
