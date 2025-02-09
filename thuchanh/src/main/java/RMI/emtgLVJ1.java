package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class emtgLVJ1 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);

        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN669", "emtgLVJ1");
        System.out.println(book);

        String name[] = book.author.trim().split("\\s+");
        String id = "";

        id += String.valueOf(name[0].charAt(0)).toUpperCase();
        id += String.valueOf(name[name.length - 1].charAt(0)).toUpperCase();

        id += String.valueOf(book.yearPublished % 100) + String.valueOf(book.title.length());
        int cnt = book.pageCount;
        if (cnt == 1) {
            id += "00" + cnt;
        } else if (cnt == 2) {
            id += "0" + cnt;
        } else id += cnt;

        book.code = id;
        System.out.println(book);
        sv.submitObject("B21DCCN669", "emtgLVJ1", book);
    }
}
