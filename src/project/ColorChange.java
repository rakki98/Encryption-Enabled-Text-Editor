
package project;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class ColorChange extends Command{
   
    String previous,current;
    JTextArea textArea;
    int fontsize;
    JComboBox FontStyle;

    public ColorChange(JTextArea textArea,JComboBox FontStyle,String current,String previous) {
        this.textArea=textArea;
        this.current=current;
        this.previous=previous;
        this.FontStyle=FontStyle;
    
    }
    

    @Override
    void execute() {
       { 
          if(current=="red")
                {
            textArea.setForeground(Color.red);
          }
          if(current=="green")
          {
            textArea.setForeground(Color.green);
          }
          if(current=="yellow")
          {
            textArea.setForeground(Color.yellow);
          }
          if(current=="pink")
          {
            textArea.setForeground(Color.pink);
          } 
        if(current=="blue")
          {
            textArea.setForeground(Color.blue);
          } 
                if(current=="black")
                {
            textArea.setForeground(Color.black);
          }

        
    }
    }

    @Override
    void unexecute() {
        if(previous=="black")
                {
            textArea.setForeground(Color.black);
          }
        
        if(previous=="red")
                {
            textArea.setForeground(Color.red);
          }
          if(previous=="green")
          {
            textArea.setForeground(Color.green);
          }
          if(previous=="yellow")
          {
            textArea.setForeground(Color.yellow);
          }
          if(previous=="pink")
          {
            textArea.setForeground(Color.pink);
          } 
        if(previous=="blue")
          {
            textArea.setForeground(Color.blue);
          } 
       
    }
    
    
}
