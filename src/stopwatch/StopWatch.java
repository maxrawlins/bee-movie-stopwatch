
package stopwatch;

import java.awt.Toolkit;
import java.util.*;
import java.io.*;

public class StopWatch {


    public static void main(String[] args) {
      clockFace start = new clockFace(); 
        Toolkit tk = Toolkit.getDefaultToolkit();
        

        start.setSize(300,300);
        start.setVisible(true);
    }
    
}
