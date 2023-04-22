import java.util.ArrayList;

public interface Tree {
    public void insert(String key, String vakue);
    public String getTranslation(String key);
    public void setNodes(ArrayList<String> translations);
}
