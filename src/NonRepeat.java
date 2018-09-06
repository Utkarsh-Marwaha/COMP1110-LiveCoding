import java.util.HashMap;

public class NonRepeat {

    public static char firstNonRepeatingChar(String str){

        HashMap<Character,Integer> freqTable = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            if (freqTable.containsKey(str.charAt(i))){
                freqTable.put(str.charAt(i),freqTable.get(str.charAt(i))+1);
            } else {
                freqTable.put(str.charAt(i),1);
            }
        }

        char c=str.charAt(0);

        for (int i = 0; i < str.length(); i++){
            if (freqTable.get(str.charAt(i))==1){
               c = str.charAt(i); break;
            }
        }

        return c;
    }
}
