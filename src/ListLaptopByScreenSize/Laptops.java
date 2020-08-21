package ListLaptopByScreenSize;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.ArrayList;
import java.util.List;

public class Laptops {
    public static void main(String[] args){
        List<Screen> screens=List.of(
                new Screen(18),
                new Screen(19),
                new Screen(19),
                new Screen(19),
                new Screen(18),
                new Screen(20),
                new Screen(20),
                new Screen(20)
        );
        List<Screen> sorted=getSortedList(screens);
        System.out.println(sorted);
    }
    private static List<Screen> getSortedList(List<Screen> screens){
        List<Screen> sorted=new ArrayList<>(screens);
        sorted.sort((s1,s2)->s2.size-s1.size);
        return List.copyOf(sorted);
    }
    public static final class Screen{
        private final int size;

        public Screen(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return String.valueOf(size);
        }
    }
}
