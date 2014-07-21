import java.util.ArrayList;
import java.util.List;

public class s {
    public static void main(String[] args) {
    List<Integer> s = new ArrayList<Integer>();
    s.add(9);
    s.add(5);
    s.add(8);
    int setSize = s.size();
    int finalValue = (int) (Math.pow(2, setSize));
    String bValue = "";
    for (int i = 0; i < finalValue; i++) {
        bValue = Integer.toBinaryString(i);
        int bValueSize = bValue.length();
        for (int k = 0; k < (setSize - bValueSize); k++) {
            bValue = "0" + bValue;
        }
        System.out.print("{ ");
        for (int j = 0; j < setSize; j++) {
            if (bValue.charAt(j) == '1') {
                System.out.print((s.get(j)) + " ");
            }
        }
        System.out.print("} ");
    }
}
}
