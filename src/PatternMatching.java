
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
    public static void main(String args[]){
        String path=System.getProperty("user.dir")+ File.separator+"res"+File.separator+"uni.txt";
        try {
            String website=new String(Files.readAllBytes(Paths.get(path)));
            String regx="(?:<a href=\")(http[s]?)(?:://)([w]{3}[^\"]+)(?:\"{1})";
            Pattern pattern=Pattern.compile(regx);
            Matcher matcher=pattern.matcher(website);
            List<String> linksList=new ArrayList<>();
            while (matcher.find()){
                linksList.add(matcher.group(2));
            }
            Map<String , Integer> groups=new HashMap<>();
            for (String link: linksList){
                System.out.println("link: \n"+link);
                String group=link;
                if (link.contains("/")) {
                    group = link.substring(0, link.indexOf("/"));
                }
                if (!groups.containsKey(group)){
                    groups.put(group,0);
                }
                int increasing=groups.get(group)+1;
                groups.put(group,increasing);
                System.out.println("without relative links:\n "+group);
                System.out.println(increasing);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
