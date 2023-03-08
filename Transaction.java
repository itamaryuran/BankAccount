public class Transaction {                      //to represent a single transaction
    private int id;
    private int amount;

    public Transaction(int id, int amount){     //constructor for transaction
        this.id = id;
        this.amount = amount;
    }

    public int getId() {return id;}             ///getters and setters

    public int getAmount() {return amount;}

    public void setId(int id) {this.id = id;}

    public void setAmount(int amount) {this.amount = amount;}

    @Override
    public String toString() {
        return ("**TRANSACTION** ID: "+getId()+" AMOUNT: "+getAmount());
    }
}
