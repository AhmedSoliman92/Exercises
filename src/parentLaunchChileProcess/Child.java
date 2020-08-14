package parentLaunchChileProcess;

import java.io.*;

import static java.lang.Thread.sleep;

public class Child {
    public static void main(String []args) throws IOException, InterruptedException {
        int c;
        System.out.println("Let's Echo: ");
        while((c=System.in.read())!='\n'){
            System.out.println((char)c);
        }
        File file=new File("Child Process.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("file"));
        int counter=0;
        while(counter<=50){
            System.out.println(counter);
            counter++;
            bufferedWriter.write(counter);
            bufferedWriter.flush();
            sleep(1000);
            if (System.in.available()>0){
                c=System.in.read();
                if (c=='*'){
                    counter=0;
                }
            }
            bufferedWriter.close();
        }
    }
}
