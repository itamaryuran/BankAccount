public class Account {
    private int id;                             //account number
    private int balance;                        //account balance
    private final Object lock = new Object();   //create lock obj for syncronisation

    public Account(int id, int balance) {       //account constructor
        this.id = id;
        this.balance = balance;
    }

    public int getId() {                    //getters and setters
        return this.id;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {                  ///to override toString
        return ("~ACCOUNT STATUS~ ID: " + getId() + " BALANCE: " + getBalance());
    }

    public synchronized void transaction(int num,int tellerid) {             //transaction method
        synchronized (lock) {
            while ((this.getBalance() < 0 && num < 0) || (this.getBalance() >= 0 && this.getBalance() + num < 0)) {
                try {                                              //this loop is for tranactions who will cause overdrafts
                    wait();                                       //these transactions wait until the transaction will not cause overdraft
                } catch (InterruptedException e) {
                }
            }
            this.setBalance(this.getBalance() + num);       //make the transaction
            lock.notifyAll();                               //notify transactions that wait that they can try again
            String s = num + (num < 0 ? " pesos where withdrawn from" : " pesos deposited in ") + "Account number: ";
            s+= getId() + "\n"+this.toString();
            s +="\nteller id: "+tellerid+"\n";
            System.out.println(s);                          //this string is printed after a transaction is made.
        }
    }
}