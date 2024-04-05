import java.util.*;;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("You are welcome ");
        boolean run = true;

        List<Customer> cst = new ArrayList<>();
        Customer c1 = new Customer("1001", 1000, "101");
        Customer c2 = new Customer("1002", 1002, "102");
        Customer c3 = new Customer("1003", 1003, "103");
        Customer c4 = new Customer("1004", 1004, "104");
        cst.add(c1);
        cst.add(c2);
        cst.add(c3);
        cst.add(c4);
        
        while(run){
            System.out.println("1.AMOUNT WITHDRAW");
            System.out.println("2.DEPOSIT");
            System.out.println("3.CHECK BALANCE");
            System.out.println("4.PIN CHANGE");
            System.out.println("5.PIN GENERATE");
            System.out.println("6.EXIT");
            System.out.println("PLEASE ENTER YOUR OPTION");
            int option = sc.nextInt();

            switch(option){
                case 1:
                withdraw(cst);
                break;
                case 2:
                deposite(cst);
                break;
                case 3:
                check_balance(cst);
                break;
                case 4:
                pin_change(cst);
                break;
                case 5:
                pin_generate(cst);
                break;
                case 6:
                run = false;
                System.out.println("THANK YOU VISIT AGAIN");
                break;
                default:
                System.out.println("ENTER A VALID OPTION");

            }
        }
        
    }
    public static void withdraw(List<Customer> cst) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ENTER YOUR ACCOUNT NO");
        String acc = sc.nextLine();
        System.out.println("ENETR YOUR PIN");
        String pin = sc.nextLine();
        boolean flag = true;
        for(Customer obj : cst){
            if(obj.getaccountno().equals(acc)){
                if(obj.getpin().equals(pin)){
                    System.out.println("ENETR THE AMOUNT");
                    int bal = sc.nextInt();
                    if(obj.getbal() >= bal){
                        obj.setbal(obj.getbal() - bal);
                        flag =true;
                    }
                    else{
                        System.out.println("INSUFFICIENT BALANCE");
                    }
                }
            }
        }
        if(flag) System.out.println("SUCCESSFULLY WITHDRAW");
        else System.out.println("ACCOUNT NO AND PIN MISMATCH");
        
    }

    public static void deposite(List<Customer> cst) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ENTER YOUR ACCOUNT NO");
        String acc = sc.nextLine();
        System.out.println("ENETR YOUR PIN");
        String pin = sc.nextLine();
        boolean flag = true;
        for(Customer obj : cst){
            if(obj.getaccountno().equals(acc)){
                if(obj.getpin().equals(pin)){
                    System.out.println("ENETR THE AMOUNT");
                    int bal = sc.nextInt();
                    obj.setbal(obj.getbal()+bal);
                    flag =true;
                }
            }
        }
        if(flag) System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
        else System.out.println("ACCOUNT NO AND PIN MISMATCH");
        
    }

    public static void check_balance(List<Customer> cst) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ENTER YOUR ACCOUNT NO");
        String acc = sc.nextLine();
        System.out.println("ENETR YOUR PIN");
        String pin = sc.nextLine();
        boolean flag =true;
        for(Customer obj : cst){
            if(obj.getaccountno().equals(acc)){
                if(obj.getpin().equals(pin)){
                    System.out.println("AVAILABLE BALANCE IS   " + obj.getbal());    
                    flag =false;                
                }
            }
        }
        if(flag) System.out.println("ACCOUNT NO AND PIN MISMATCH");
        
    }

    public static void pin_change(List<Customer> cst) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ENTER YOUR ACCOUNT NO");
        String acc = sc.nextLine();
        System.out.println("ENETR YOUR OLD PIN");
        String pin = sc.nextLine();
        boolean flag = true;
        for(Customer obj : cst){
            if(obj.getaccountno().equals(acc)){
                if(obj.getpin().equals(pin)){
                    System.out.println("ENETR YOUR NEW PIN");
                    String npin = sc.nextLine();
                    System.out.println("REENETR YOUR NEW PIN");
                    String rnpin = sc.nextLine();
                    if(npin.equals(rnpin)){
                        obj.setpin(npin);
                        flag =true;
                    }
                    else{
                        System.out.println("ENTERED PIN IS MISMATCHED");
                    }
                    
                }
            }
        }
        if(flag) System.out.println("PIN CHANGED SUCCESSFULLY");
        else System.out.println("ACCOUNT NO AND PIN MISMATCH");
        
    }

    public static void pin_generate(List<Customer> cst) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR ACCOUNT NO");
        String acc = sc.nextLine();
        System.out.println("ENETR YOUR PIN");
        String pin = sc.nextLine();
        System.out.println("REENETR YOUR PIN");
        String rpin = sc.nextLine();
        if(pin.equals(rpin)){
           Customer c5 = new Customer(acc, 1000, pin);
           cst.add(c5);
        }
        else{
            System.out.println("ENTERED PIN IS MISMATCHED");
        }
       
    }

    
}

class Customer {
    
    String accountno;
    int bal ;
    String pin ;

    Customer(String accountno , int bal , String pin){
        this.accountno = accountno;
        this.bal = bal;
        this.pin = pin;
    } 
    public void setpin(String pin) {
        this.pin = pin;
    }
    public void setbal(int bal) {
        this.bal = bal;
    }
    public int getbal() {
        return bal;
    }
    public Object getpin() {
        return pin;
    }
    public String getaccountno(){
        return accountno;
    }
}
