package ArrayLists.Ejer5x25;

import java.util.Objects;

public class Cuenta {
    public String nombre;
    public int num;
    public int balance;

    public Cuenta(String nombre,int num, int balance) {
        this.nombre = nombre;
        this.num = num;
        this.balance = balance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return num == cuenta.num && balance == cuenta.balance && Objects.equals(nombre, cuenta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cuenta{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", num=").append(num);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
