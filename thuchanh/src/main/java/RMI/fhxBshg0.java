package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fhxBshg0 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);

        DataService sv = (DataService) reg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN669", "fhxBshg0");
        System.out.println(s);
        String ans = sinh(s);
        System.out.println(ans);
        sv.submitData("B21DCCN669", "fhxBshg0", ans);
    }

    public static String sinh(String s) {
        String[] q = s.split(", ");
        int n = q.length;
        List<Integer> vt = new ArrayList<>();
        for (String i : q) {
            vt.add(Integer.parseInt(i));
        }
        int k = n - 2;
        while (k >= 0 && vt.get(k) >= vt.get(k + 1)) {
            k--;
        }

        if (k < 0) {
            Collections.sort(vt);
            String ans = "";
            for (int i : vt) {
                ans += i + ",";
            }
            return ans.substring(0, ans.length() - 1);
        }

        int m = n - 1;
        while (m > k && vt.get(m) <= vt.get(k)) {
            m--;
        }
        int a = vt.get(k);
        int b = vt.get(m);
        vt.set(k, b);
        vt.set(m, a);
        int l = k + 1, r = n - 1;
        while (l < r) {
            int x = vt.get(l);
            int y = vt.get(r);
            vt.set(l, y);
            vt.set(r, x);
            l++;
            r--;
        }

        String ans = "";
        for (int i : vt) {
            ans += i + ",";
        }
        return ans.substring(0, ans.length() - 1);
    }
}
