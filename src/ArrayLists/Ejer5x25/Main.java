package ArrayLists.Ejer5x25;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.addCuenta("maximo",1,100);
        banco.addCuenta("sara",2,300);
        banco.addCuenta("martin",3,-100);

        System.out.println(banco.getCuenta("maximo"));
         banco.listarClientes();
    }
}
