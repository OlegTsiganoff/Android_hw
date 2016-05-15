import java.io.File;

/**
 * Created by Олег on 27.03.2016.
 */
public abstract class AbstractHandler {
    public abstract File Open(String filePath);
    public abstract File Create(String filePath);
    public abstract void Change(String filePath, String newData);
    public abstract void Save(String filePath);
}
