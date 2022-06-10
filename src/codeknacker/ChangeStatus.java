package codeknacker;

public class ChangeStatus {
    private static CodeKnackerStatus aktuellerZustand = CodeKnackerStatus.PLAYER1_ACTIVE;

    public static CodeKnackerStatus getStatus(){
        return aktuellerZustand;
    }

    public static void setStatus(CodeKnackerStatus neuZustand){
        aktuellerZustand = neuZustand;
    }
}
