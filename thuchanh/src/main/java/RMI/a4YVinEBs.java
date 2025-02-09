package RMI;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.*;
public class a4YVinEBs {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);

        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        byte[] data = sv.requestData("B21DCCN669", "4YVinEBs");

        int shift = data.length;

        for (int i = 0; i < shift; i++) {
            data[i] = (byte) (data[i] + shift); // Dịch chuyển giá trị byte
        }
        sv.submitData("B21DCCN669", "4YVinEBs", data);
    }
}
