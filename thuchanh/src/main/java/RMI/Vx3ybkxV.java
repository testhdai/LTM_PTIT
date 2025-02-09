package RMI;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Vx3ybkxV {
    public static void main(String[] args) throws RemoteException, NotBoundException, UnsupportedEncodingException {
        Registry sv = LocateRegistry.getRegistry("203.162.10.109", 1099);

        CharacterService service = (CharacterService) sv.lookup("RMICharacterService");
        String s = service.requestCharacter("B21DCCN669", "Vx3ybkxV");
        System.out.println(s);

//        String ans = "";
        String ans = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
        String x = URLEncoder.encode(s);
        System.out.println(x);
//        for (int i = 0; i < s.length(); i++) {
//            char x = s.charAt(i);
//
//            if (!Character.isAlphabetic(x) && !Character.isDigit(x)) {
//                int a = (int) x;
//                ans += "%" + a;
//            } else {
//                ans += x;
//            }
//        }

        System.out.println(ans);
        service.submitCharacter("B21DCCN669", "Vx3ybkxV", x);
    }
}
