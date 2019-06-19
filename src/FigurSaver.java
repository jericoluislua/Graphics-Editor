import java.io.*;
import java.util.Vector;

public class FigurSaver {
    private int num = 1;
    public void save(Vector<Figur> f) throws IOException{
        String txt = ".txt";
        String pfad = "C:/Users/vmadmin/IdeaProjects/Grafikeditor/txtfiles/" + f.size();
        File file = new File(pfad + txt);
        while(file.exists()){
            pfad = "C:/Users/vmadmin/IdeaProjects/Grafikeditor/txtfiles/" + f.size() + "_" + (num++);
            file = new File(pfad + txt);
        }



        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(f);
        pw.close();
    }
}
