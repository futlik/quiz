import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * This class is thread safe.
 */
public class Parser {
  private File file; // final
  public synchronized void setFile(File f) {
    file = f;
  }
  public synchronized File getFile() {
    return file;
  }
  
  // File as args
  // static
  public String getContent() throws IOException {
    // use library
    // use bufferedStream
    // close - try with resource
    FileInputStream i = new FileInputStream(file);
    String output = ""; // use StringBuilder 
    int data;
    while ((data = i.read()) > 0) { // read - size ? byte
      output += (char) data; // encoding ?
    }
    return output;
  }
  public String getContentWithoutUnicode() throws IOException { // remove throws?
    FileInputStream i = new FileInputStream(file); 
    String output = "";
    int data;
    while ((data = i.read()) > 0) {
      if (data < 0x80) { // magic
        output += (char) data;
      }
    }
    return output;
  }
  
  // to static
  // to another class
  // throws ?
  public void saveContent(String content) { // use library
   
    FileOutputStream o = new FileOutputStream(file); // use buffered
    try { // with resource
      for (int i = 0; i < content.length(); i += 1) { // encoding to byte
        o.write(content.charAt(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // close
  }
}
