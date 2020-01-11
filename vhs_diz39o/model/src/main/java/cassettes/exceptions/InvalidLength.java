package cassettes.exceptions;

public class InvalidLength extends Exception  {
    public InvalidLength(){
    }

    public InvalidLength(String s){
        super(s);
    }
}
