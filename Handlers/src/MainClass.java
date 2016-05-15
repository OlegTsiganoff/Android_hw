import java.io.File;
import java.util.Scanner;

/**
 * Created by Олег on 27.03.2016.
 */
public class MainClass {
    public static void main (String... args)
    {
        Scanner in = new Scanner(System.in);
        String path;
        File file = null;
        while(true) {
            System.out.println("Enter 'exit' to exit. ");
            System.out.println("Create file: enter file path with extension: -c 'C:/file.txt'");
            System.out.println("Open file: enter file path with extension: -o 'C:/file.txt'");
            System.out.println("Append text to file: enter file path with extension: -ch 'C:/file.txt' t:<text> ");
            if(file != null)
                System.out.println("Save file: enter file path with extension: -s 'C:/file.txt'");
            path = in.nextLine();
            String action = "";
            if(path.contains("-c")) {
                action = "create";
                path.replace("-c", "");
            }

            if(path.contains("-o")) {
                action = "open";
                path.replace("-o","");
            }

            String text = "";
            if(path.contains("-ch")) {
                action = "change";
                text = path.substring(path.indexOf("t:") + 2, path.length());
                path.replace("-ch","");
            }

            if(path.contains("-s")) {
                action = "save";
                path.replace("-s", "");
            }

            if (path == "exit")
               return;

            file = new File(path);
            AbstractHandler handler = getFileHandler(file);
            if (handler != null) {
               switch(action)
                {
                    case "open":
                        handler.Open(path);
                        break;
                    case "create":
                        handler.Create(path);
                        break;
                    case "change":
                        handler.Change(path, text);
                        break;
                    case "save":
                        handler.Save(path);
                        break;
                }
            }
        }




    }

    static AbstractHandler getFileHandler(File file)
    {
        if(file == null)
            return null;
        AbstractHandler handler = null;
        String extention = getFileExtension(file);
        switch (extention)
        {
            case "txt":
            case "TXT":
                handler = new TXTHandler();
                break;
            case "doc":
            case "DOC":
                handler = new DOCHandler();
                break;
            case "xml":
            case "XML":
                handler = new XMLHandler();
                break;
        }
        return handler;
    }

    static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
