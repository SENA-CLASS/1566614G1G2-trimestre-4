package co.edu.sena.ejemplopoo.collections;

public class Mesa {
    private int id;

    public Mesa(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                '}';
    }
}
