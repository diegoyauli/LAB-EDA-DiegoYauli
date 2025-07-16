package Laboratorio9.EjercicioPropuesto3;

public class Register<E> {
    private int key;
    private E value;
    private boolean deleted;

    public Register(int key, E value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    // Getters y setters
    public int getKey() { return key; }
    public E getValue() { return value; }
    public void setValue(E value) { this.value = value; }
    public boolean isDeleted() { return deleted; }
    public void delete() { this.deleted = true; }

    @Override
    public String toString() {
        return (deleted ? "[ELIMINADO] " : "") + key + ": " + value;
    }
}
