package ArrayLists.Ejer5x26;

public class Main {
    public static void main(String[] args) {
        ListinTelefonico lt = new ListinTelefonico();

        lt.introducirNumero("max","54654313");
        lt.introducirNumero("xaxa","111111111");
        lt.introducirNumero("val","111111111");

        System.out.println(lt.buscarNumero("val"));
        lt.escribirListin();
    }
}
