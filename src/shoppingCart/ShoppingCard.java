package shoppingCart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShoppingCard {
    public static void main(String[] args){
        ShoppingBasket card1=new ShoppingBasket(new ArrayList<>());
        ShoppingBasket card2= card1.addObject(new ShoppingObject("pen",10),new ShoppingObject("pencil",15),new ShoppingObject("book",50));
        ShoppingBasket card3=card2.removeObject(new ShoppingObject("pen",10),new ShoppingObject("pencil",15));
        ShoppingBasket card4=card3.addObject(new ShoppingObject("pen",10),new ShoppingObject("pencil",15),new ShoppingObject("book",50));
        ShoppingBasket card5=card4.addObject(new ShoppingObject("pen",10),new ShoppingObject("pencil",15),new ShoppingObject("book",50));
        System.out.println("card1: "+card1);
        System.out.println("card2: "+card2);
        System.out.println("card3: "+card3);
        System.out.println("card4: "+card4);
        System.out.println("card5: "+card5);
    }
    private static final class ShoppingBasket {
        @Override
        public String toString() {
            return "ShoppingBasket{" +
                    "shoppingList=" + shoppingList +
                    '}';
        }

        List<ShoppingObject> shoppingList;

        public ShoppingBasket(List<ShoppingObject> sl) {
            this.shoppingList= Collections.unmodifiableList(sl);
        }

        public  ShoppingBasket addObject(ShoppingObject... objects){
            List<ShoppingObject> sl=new ArrayList<>(shoppingList);
            Collections.addAll(sl, objects);
            return new ShoppingBasket(sl);
        }
        public ShoppingBasket removeObject(ShoppingObject... objects){
            List<ShoppingObject>sl=new ArrayList<>(shoppingList);
            for (ShoppingObject object:objects){
                sl.remove(object);
            }
            return new ShoppingBasket(sl);
        }
    }
    public static final class ShoppingObject {
        private final String name;
        private final int price;

        public ShoppingObject(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ShoppingObject object = (ShoppingObject) o;
            return price == object.price &&
                    Objects.equals(name, object.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        @Override
        public String toString() {
            return "ShoppingObject{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
