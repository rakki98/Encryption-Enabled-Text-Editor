
package project;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class StyleChange extends Command{
    String previous,current;
    JTextArea textArea;
    int fontsize;
    JComboBox FontStyle;

    public StyleChange(JTextArea textArea,JComboBox FontStyle,String current,String previous,int fontsize) {
        this.textArea=textArea;
        this.current=current;
        this.previous=previous;
        this.fontsize=fontsize;
        this.FontStyle=FontStyle;
    
    }
    

    @Override
    void execute() {
            textArea.setFont(new Font(current, Font.PLAIN, fontsize));
            System.out.println("project.StyleChange.execute()");
    }

    @Override
    void unexecute() { 
            textArea.setFont(new Font(previous, Font.PLAIN, fontsize));
            System.out.println("project.StyleChange.unexecute()");
        
    }
    

   }
       
       
       