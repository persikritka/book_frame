package tables;

public class Information {
    private int idInformation;
    private int idBook;
    private int cost;
    private int circulation;

    public int getIdInformation() {
        return idInformation;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getCost() {
        return cost;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setIdInformation(int idInformation) {
        this.idInformation = idInformation;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }
}
