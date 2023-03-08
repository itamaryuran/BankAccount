import java.util.ArrayList;
import java.util.Random;

public class Bank {

        final int MAXACCOUNTS = 5;                    //num of accounts
        final int PSIZE = 100;                   //num of transactions in pool
        final int MAXTRANSACTION = 1000;          //max of money per transaction
        final int MAXT = 10;                   //num of tellers

        Random r = new Random();
        ArrayList<Transaction> arr = new ArrayList<>(); //transactions arr for transactions pool

        public Bank(){
        Teller[] tellers = new Teller[MAXT];            //arr of tellers
        Account[] accounts = new Account[MAXACCOUNTS];         //arr of accounts
        for (int i = 0; i < MAXACCOUNTS; i++) {
            accounts[i] = new Account(i,0);      //fill arr of accounts
        }

        for (int P = 0; P < PSIZE; P++) {                //fill arr pool of transactions
            Transaction t = new Transaction(r.nextInt(MAXACCOUNTS), r.nextInt(-MAXTRANSACTION,MAXTRANSACTION));
            arr.add(t);
        }
        TransactionPool pool = new TransactionPool(arr); //assign arr to transactions pool

            for (int i = 0; i < MAXT; i++) {             //fill arr of tellers
                tellers[i] = new Teller(pool,accounts,i);
            }
            for (Teller teller:tellers) {               //start tellers
                teller.start();
            }

    }
}
