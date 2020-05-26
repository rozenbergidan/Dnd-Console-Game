package Control;

public interface ScreenWriter {
    void print(String output);
//    //could also be anonimus class
//    private static ScreenWriter instance=null;
//    private String save;
//    private ScreenWriter(){save="";}
//
//    public static ScreenWriter getScreanWriter(){
//        if(instance==null) instance=new ScreenWriter();
//        return instance;
//    }
//
//    public void printToScreen(String str){
//        System.out.println(str);
//        save=save+"\n"+str;
//    }
//
//    public void saveGame(){
//        //IO files gets save
//    }
}
