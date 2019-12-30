public class Main {
    public static void main(String[] args) {
        Block genesisBlock = new Block("First block", "0");
        System.out.println("First block: " + genesisBlock.getHash());

        Blockchain blockchain = new Blockchain();
        blockchain.add(1);

    }
}
