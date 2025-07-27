import java.util.Scanner;

class Payments {
    int userAmount;
    int limit = 10000;
    String paymentMethod;

    Payments(int userAmount, String paymentMethod) {
        this.userAmount = userAmount;
        this.paymentMethod = paymentMethod;
    }
    String paymentSuccess() {
        if (userAmount > 0 && userAmount <= limit) {
            return "Rupees " + userAmount + " sent successfully\nPayment Status: Done";
        } else {
            return " ";
        }
    }

    String paymentFailed() {
        if (userAmount > limit) {
            return "Oops! You can't send that amount. It exceeds the maximum limit.";
        } else {
            return "Try Again Later..";
        }
    }
}
class Balance extends Payments {
    Balance(int userAmount, String paymentMethod) {
        super(userAmount, paymentMethod);
    }
    double getBalance() {
        if (userAmount <= 0) {
            System.out.println("Insufficient Balance.");
            return 0;
        }
        return userAmount;
    }
}
class PaymentMethods extends Payments {
    PaymentMethods(int userAmount, String paymentMethod) {
        super(userAmount, paymentMethod);
    }

    void upi(String upiId) {
        System.out.println("UPI ID: " + upiId);
        System.out.println(paymentSuccess());
    }
    void creditCard(long cardNumber) {
        System.out.println("Credit Card Number: " + cardNumber);
        System.out.println(paymentSuccess());
    }
    void debitCard(long cardNumber) {
        System.out.println("Debit Card Number: " + cardNumber);
        System.out.println(paymentSuccess());
    }
}

public class PaymentSystem {
    public static String upiId;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose a Payment Method [1]UPI [2]CreditCard [3]DebitCard: ");
        String userMethod = sc.nextLine();

        System.out.print("Enter Amount to Send: ");
        int amount = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();

        PaymentMethods payMethod = new PaymentMethods(amount, userMethod);

        if (userMethod.equalsIgnoreCase("Upi")) {
            System.out.print("Enter UPI ID: ");
            upiId = sc.nextLine();
            if (upiId.length() == 10) {
                payMethod.upi(upiId);
            } else {
                System.out.println("Invalid UPI ID. Try again.");
            }

        } else if (userMethod.equalsIgnoreCase("CreditCard")) {
            System.out.print("Enter Credit Card Number: ");
            long cardNo = sc.nextLong();
            payMethod.creditCard(cardNo);

        } else if (userMethod.equalsIgnoreCase("DebitCard")) {
            System.out.print("Enter Debit Card Number: ");
            long cardNo = sc.nextLong();
            payMethod.debitCard(cardNo);

        } else {
            System.out.println("Invalid Payment Method Selected.");
        }

        sc.close();
    }
}
