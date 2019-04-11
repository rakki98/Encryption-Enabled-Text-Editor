/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author rakshith
 */
public class SizeChange extends Command{
    
     int current,previous;
     String font;
     boolean bold,italic;      
    JTextArea textArea;
    
    JComboBox FontStyle;

    public SizeChange(JTextArea textArea,JComboBox Size,int current,int previous,String fontstyle){
        this.textArea=textArea;
        this.current=current;
        this.previous=previous;
        this.font=font;
        this.FontStyle=Size;
      
    
    }

    @Override
    void execute() {
      textArea.setFont(new Font(font, Font.PLAIN,current));
            System.out.println("project.StyleChange.execute()");
    }

    @Override
    void unexecute() {
         textArea.setFont(new Font(font, Font.PLAIN,previous));
            System.out.println("project.StyleChange.unexecute()" + previous);
            FontStyle.setSelectedItem(previous);
        
    }
   

   
}
