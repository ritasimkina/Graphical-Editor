package Debug;

import java.util.Set;

public class Debug {
    //https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html
    static int insert_minus=2;

    public static void out(Thread thread)   {
        out(thread,"",insert_minus+1);
    }
    public static void out(Thread thread, String string)   {
        out(thread, string,insert_minus+1);
    }
    private static void out(Thread thread, String string,int level)   {
        final StackTraceElement[] ste = thread.getStackTrace();
        //Set<Thread> threads = Thread.getAllStackTraces().keySet();

        String s="";
        for(int i=insert_minus;i<ste.length;i++) s+=("|\t");
        s+=ste[level].getLineNumber()+": ";
        s+=thread.getName()+"\t";
        s+=ste[level].getClassName()+"::";
        s+=ste[level].getMethodName()+"()";
        if(string.length()>0) s+="\t\t--> "+string;

        //System.out.println( s );
    }



    public static void signal(Thread thread)   {
        signal(thread,"",insert_minus+1);
    }
    public static void signal(Thread thread, String string)   {
        signal(thread, string,insert_minus+1);
    }
    private static void signal(Thread thread, String string,int level)   {
        final StackTraceElement[] ste = thread.getStackTrace();
        String s="";
        s+=ste[level].getLineNumber()+": ";
        s+=thread.getName()+"\t";
        s+=ste[level].getClassName()+"::";
        s+=ste[level].getMethodName()+"()";
        if(string.length()>0) s+="\t\t--> "+string;
        System.out.println( s );
    }


}
