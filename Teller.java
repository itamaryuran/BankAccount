import java.util.Random;

public class Teller extends Thread{
    private TransactionPool pool;           //referance to transaction pool
    private Account[] accounts;             //arr of accounts in the bank
    private int tellerId;

    public Teller(TransactionPool pool, Account[] accounts, int tellerId){//teler constructor
        this.pool = pool;
        this.accounts = accounts;
        this.tellerId = tellerId;
    }

    @Override
    public void run() {             //teller's func, takes a transaction and apply it if possible
        Random r = new Random();
        Transaction t;
        t = pool.getTransaction();  //the next transaction
        while (t!= null) {          //while there are transactions in pool
            accounts[t.getId()].transaction(t.getAmount(),this.tellerId);//apply transaction on the wanted account.
            try {
                sleep(r.nextLong(100));     //break for teller between transactions
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t = pool.getTransaction();      //next transaction
        }
    }
}
