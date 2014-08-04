package by.zloy.interview;

import java.util.HashMap;

/**
 * Work with hashcode and equals
 */
public class HashcodeAndEquals {

    public static void main(String a[]) {

        HashMap<Price, String> hm = new HashMap<Price, String>();
        hm.put(new Price("Banana", 20), "Andrew");
        hm.put(new Price("Apple", 40), "Olya");
        hm.put(new Price("Orange", 30), "Eugene");
        hm.put(new Price("Orange", 30), "Lena");
        hm.put(new Price("Orange", 40), "Dima");
        hm.put(null, "Vova");

        Price key = new Price("Orange", 30);

        System.out.println("Value from map: " + hm.get(key));
    }

    static class Price {

        private String item;
        private int price;

        public Price(String itm, int pr) {
            this.item = itm;
            this.price = pr;
        }

        public int hashCode() {
            System.out.println("Call hashcode");
            int hashcode = price * 47;
            hashcode += item.hashCode();
            return hashcode;
        }

        public boolean equals(Object obj) {
            System.out.println("Call equals");
            if (obj instanceof Price) {
                Price pp = (Price) obj;
                return (pp.item.equals(this.item) && pp.price == this.price);
            } else {
                return false;
            }
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}

