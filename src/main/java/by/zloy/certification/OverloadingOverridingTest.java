package by.zloy.certification;

public class OverloadingOverridingTest {
    public static void main(String[] args) {

        // Example of method overloading in Java
        Loan cheapLoan = Loan.createLoan("HSBC");
        Loan veryCheapLoan = Loan.createLoan("Citibank");

        // Example of method overriding in Java
        Loan personalLoan = new PersonalLoan();
        System.out.println(personalLoan.toString());
    }


    static public class Loan {
        private double interestRate;
        private String customer;
        private String lender;

        public static Loan createLoan(String lender) {
            Loan loan = new Loan();
            loan.lender = lender;
            return loan;
        }

        public static Loan createLoan(String lender, double interestRate) {
            Loan loan = new Loan();
            loan.lender = lender;
            loan.interestRate = interestRate;
            return loan;
        }

        @Override
        public String toString() {
            return "This is Loan by Citibank";
        }

    }

    static public class PersonalLoan extends Loan {

        @Override
        public String toString() {
            return "This is Personal Loan by Citibank";
        }
    }

}
