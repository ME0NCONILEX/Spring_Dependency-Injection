package se.me0nly.Data_Access.NewSeq;

public class StudentIdNewSeq {
    private static int seq = 0;

    public static int nextId(){
        return ++seq;
    }
}
