package Control;

public class ScreenWriter {

    private static ScreenWriter instance = null;

    private ScreenWriter (){}

    public static ScreenWriter getScreenWriter(){
        if(instance==null) instance=new ScreenWriter();
        return instance;
    }

    public void print(String str){
        System.out.println(str);
    }
}
