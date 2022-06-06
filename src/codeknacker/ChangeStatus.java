package codeknacker;

public class ChangeStatus {
    private CodeKnackerStatus aktuellerZustand = null;

    public CodeKnackerStatus getStatus(){
        return aktuellerZustand;
    }

    public void setStatus(CodeKnackerStatus neuZustand){
        this.aktuellerZustand = neuZustand;
    }
}
