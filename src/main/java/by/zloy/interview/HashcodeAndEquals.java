package by.zloy.interview;

import java.util.HashMap;

/**
 * Work with hashcode and equals
 */
public class HashcodeAndEquals {

    public static void main(String a[]) {

        HashMap<Product, String> hm = new HashMap<Product, String>();
        hm.put(new Product("Banana", 1), "Andrew");
        hm.put(new Product("Orange", 2), "Eugene");
        hm.put(new Product("Orange", 2), "Lena");
        hm.put(new Product("Orange", 3), "Dimitry");
        hm.put(new Product("Apple", 2), "Olga");
        hm.put(new Product("Apple", 3), "Victor");
        hm.put(null, "Vladimir");

        Product key = new Product("Orange", 3);

        System.out.println("Value from map: " + hm.get(key));
    }

    static class Product {

        private String name;
        private int price;

        public Product(String itm, int pr) {
            this.name = itm;
            this.price = pr;
        }

        public int hashCode() {
            System.out.println("Call hashcode");
            int hashcode = 47;

            hashcode = hashcode * price;
            hashcode += name.hashCode();

            return hashcode;
        }

        public boolean equals(Object obj) {
            System.out.println("Call equals");
            if (obj instanceof Product) {
                Product pp = (Product) obj;

                boolean bPrice = pp.price == this.price;
                boolean bName = pp.name.equals(this.name);
                return bPrice && bName;
            } else {
                return false;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}

