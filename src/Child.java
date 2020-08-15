import java.io.*;

import static java.lang.Thread.sleep;

public class Child {
    public static void main(String []args) throws IOException, InterruptedException {
        int c;
        System.out.println("Let's Echo: ");
        while((c=System.in.read())!='\n'){
            System.out.print((char)c);
        }
        System.out.println();
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("../res/childProcess.log")));

         int counter = 0;
            while (counter <= 10) {
                bufferedWriter.write(counter+"\n");
                bufferedWriter.flush();
                System.out.println(counter++);
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
