public class Edge {
    private int source;
    private int destination;
    private double weight;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(int source, int destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return " s:" + source
                + " d:" + destination
                + " w:" + weight;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return (source << 16) ^ destination;
    }
}
