package by.zloy.test;

// enum showing Mobile prices
enum TestEnumMobile {
    Samsung(400), Nokia(250), Motorola(325);

    int price;

    TestEnumMobile(int p) {
        price = p;
    }

    int showPrice() {
        return price;
    }
}

public class TestEnum {

    public static void main(String args[]) {

        System.out.println("CellPhone List:");
        for (TestEnumMobile m : TestEnumMobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        TestEnumMobile ret;
        ret = TestEnumMobile.valueOf("Samsung");
        System.out.println("Selected : " + ret);
    }
}