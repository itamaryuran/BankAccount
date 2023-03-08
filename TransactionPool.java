import java.util.ArrayList;


public class TransactionPool {
    private ArrayList<Transaction> arr;                             //to hold transactions

    public TransactionPool(ArrayList<Transaction> a){
        this.arr = a;
    }
    public synchronized Transaction getTransaction(){             //get next transaction. returns null if empty.
        if (arr.size()==0){
            return null;
        }
        return arr.remove(0);                               //returns and removes a transaction
    }
    public synchronized int size(){
        return arr.size();
    }       //create size method for pool
}
