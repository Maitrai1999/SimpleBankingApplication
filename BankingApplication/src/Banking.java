import java.util.Scanner;
class Banking {
    String accno;
    String name;
    long balance;
    Scanner s = new Scanner(System.in);
    void openAccount() {
        System.out.print("Enter your Account No: ");
        accno = s.next();
        System.out.print("Enter your Name: ");
        name = s.next();
        System.out.print("Enter Balance: ");
        balance = s.nextLong();
    }
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance);
    }
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = s.nextLong();
        balance = balance + amt;
    }
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = s.nextLong();
        if (balance > amt) {
            balance = balance - amt;
        } else {
            System.out.println("your balance is low......Transaction Failed!!");
        }
    }
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
    public static void main(String arg[]) {
    	// TODO Auto-generated method stub
        Scanner s1 = new Scanner(System.in);
        System.out.print("No.of Customers : ");
        int n = s1.nextInt();
        Banking a[] = new Banking[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Banking();
            a[i].openAccount();
        }
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
                System.out.println("Ur Choice :");
                ch = s1.nextInt();
                switch (ch) {
                    case 1:
                    	for (int i = 0; i < a.length; i++) {
                            a[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account Number you want to Search...: ");
                        String acn = s1.next();
                        boolean found =false;
                        for (int i = 0; i < a.length; i++) {
                            found = a[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = s1.next();
                        found = false;
                        for (int i = 0; i < a.length; i++) {
                            found = a[i].search(acn);
                            if (found) {
                                a[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = s1.next();
                        found = false;
                        for (int i = 0; i < a.length; i++) {
                            found = a[i].search(acn);
                            if (found) {
                                a[i].withdrawal();
                            }
                            
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("ThankYou!!!");
                        break;
                }
            }
            while (ch != 5);
        }
    }