package Laboratorio9.EjercicioResuelto3;

public class Element<E> {
    private Register<E> register;
    private boolean empty;

    public Element() {
        this.empty = true;
    }

    public void setRegister(Register<E> register) {
        this.register = register;
        this.empty = false;
    }

    public Register<E> getRegister() {
        return register;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void markAsDeleted() {
        if (!empty) {
            register.delete();
        }
    }

    public boolean isDeleted() {
        return !empty && register.isDeleted();
    }

    @Override
    public String toString() {
        if (empty) {
            return "[VACÍO]";
        } else if (register.isDeleted()) {
            return "[ELIMINADO]";
        } else {
            return register.toString();
        }
    }
}
