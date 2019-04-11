

package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.*;

public class demo extends javax.swing.JFrame  {
    int fontsize;
    String color,font1,font2;
    ArrayList<Integer> size;
    ArrayList<String> style;
    ArrayList<String> colo;
    ArrayList<String> files;

    public demo() throws Exception {
        initComponents();
          for(String s:GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
        { FontStyle.addItem(s);
           
        }
          files=Database.filename();
          for(String f:files)
          {   JMenuItem a=new JMenuItem(f);
              OPen.add(a);
              a.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e){
                  System.out.println(".actionPerformed()");
                  try{       int password=Integer.parseInt(JOptionPane.showInputDialog("Enter the key to decrypt"));
                             String file=a.getText();
                             setTitle(file);
                           Database.output(file,password);
                   FileReader reader=new FileReader("/home/rakshith/NetBeansProjects/Project/src/project/temp1");
                   BufferedReader bf=new BufferedReader(reader);
                   textArea.read(bf, null);
                   bf.close();
                   textArea.requestFocus();
                   File f=new File("/home/rakshith/NetBeansProjects/Project/src/project/temp1");
                 f.delete();
                  }
                  catch(Exception f)
                  {}
                  }
          });
          }
         
          color=(String)Color1.getSelectedItem();;
          font1=(String)FontStyle.getSelectedItem();
          fontsize=Integer.parseInt((String)(Size.getSelectedItem()));
          textArea.setFont(new Font(font1, Font.PLAIN, fontsize));
          size=new ArrayList<>(2);
          style=new ArrayList<>(2);
          colo=new ArrayList<>(2);
          size.add(fontsize);
          style.add(font1);
          colo.add(color);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Size = new javax.swing.JComboBox<>();
        Color1 = new javax.swing.JComboBox<>();
        FontStyle = new javax.swing.JComboBox<>();
        bold = new javax.swing.JRadioButton();
        italic = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        Undo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        OPen = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44" }));
        Size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SizeActionPerformed(evt);
            }
        });

        Color1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "black", "red", "blue", "green", "yellow", "pink" }));
        Color1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Color1ActionPerformed(evt);
            }
        });

        FontStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontStyleActionPerformed(evt);
            }
        });

        bold.setText("Bold");
        bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldActionPerformed(evt);
            }
        });

        italic.setText("Italic");
        italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        Undo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UndoKeyPressed(evt);
            }
        });

        jMenu1.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jMenu1.add(open);

        OPen.setText("Open encrypted");
        jMenu1.add(OPen);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(Color1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Undo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(bold)
                .addGap(82, 82, 82)
                .addComponent(italic)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bold)
                    .addComponent(italic)
                    .addComponent(Undo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
     try
     {
        textArea.setText("");
        setTitle("Untitled");
        
     }
     catch(Exception e)
     {}
             
    }//GEN-LAST:event_newFileActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
      try{
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
        File f=jfc.getSelectedFile();
        String filename=f.getAbsolutePath();
          setTitle(filename);
        
         FileReader reader=new FileReader(filename);
         BufferedReader bf=new BufferedReader(reader);
        textArea.read(bf, null);
        bf.close();
        textArea.requestFocus();
            
        } catch (Exception e) {
        }
        
        
        
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
                try{
              
                       String fileName = (String)JOptionPane.showInputDialog("Enter file name");
                       int key=Integer.parseInt(JOptionPane.showInputDialog("Enter the key to encrypt"));
                       setTitle(fileName);
 
                       FileWriter outFile = new FileWriter("/home/rakshith/NetBeansProjects/Project/"+fileName+".txt");
                       outFile.write(textArea.getText());
                       outFile.close();
                       
                       
                    InputStream inStr=new FileInputStream("/home/rakshith/NetBeansProjects/Project/"+fileName+".txt");
                    OutputStream outStr=new FileOutputStream("/home/rakshith/NetBeansProjects/Project/"+fileName+".enc",true);
	            encryption en;
                    en = new encryption(key);
	            en.encrypt(inStr,outStr);
                    Database.input(fileName,key);
         
                 //   File f=new File("/home/rakshith/NetBeansProjects/Project/"+fileName+".txt");
                //    f.delete();
                    outFile.close();}
                catch(Exception e)
            {}
        
    }//GEN-LAST:event_saveActionPerformed
  
    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      
        
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void boldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldActionPerformed
       font1=(String)FontStyle.getSelectedItem();
          fontsize=Integer.parseInt((String)(Size.getSelectedItem()));
          
       if(evt.getSource()==bold)
           {  if(bold.isSelected())
           { textArea.setFont(new Font(font1,Font.BOLD,fontsize));
    
           }
           else 
           {textArea.setFont(new Font(font1,Font.PLAIN,fontsize));
            }
           }
    }//GEN-LAST:event_boldActionPerformed

    private void SizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SizeActionPerformed
         if(evt.getSource()==Size)
        {
           
           int fontsize1;
           fontsize1=Integer.parseInt((String)(Size.getSelectedItem()));
           font1=(String)FontStyle.getSelectedItem();
    
 
            size.add(fontsize1);
            
            Command newCommand=new SizeChange(textArea,Size,size.get(1),size.get(0),font1);
            System.out.println(size.get(1));
            System.out.println(size.get(0));
            
                    size.remove(0);
            
            StackOfCommands.addCommand(newCommand);
            finalExecuter();
    
    
   }
       
       
       
       
       
       
       
 
    }//GEN-LAST:event_SizeActionPerformed

    
    private void FontStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontStyleActionPerformed
        // TODO add your handling code here:
       try{
       if(evt.getSource()==FontStyle)
        {   
            font2=(String)FontStyle.getSelectedItem();
            style.add(font2);
            Command newCommand=new StyleChange(textArea,FontStyle,style.get(1),style.get(0),fontsize);
            style.remove(0);
            StackOfCommands.addCommand(newCommand);
            finalExecuter();
            
            
           
        }
       }
       catch(Exception e)
       {
          
       }  
        
         
      
        
    }//GEN-LAST:event_FontStyleActionPerformed

    private void Color1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Color1ActionPerformed
        
        
      
        
            if(evt.getSource()==Color1)
 
            {
         font2=(String)Color1.getSelectedItem();
            colo.add(font2);
            Command newCommand=new ColorChange(textArea,Color1,colo.get(1),colo.get(0));
            colo.remove(0);
            StackOfCommands.addCommand(newCommand);
            finalExecuter();
    
    
        } 
    }//GEN-LAST:event_Color1ActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        try{
        if(evt.getSource()==Undo)
        {   Command un=StackOfCommands.removeCommand();
            un.unexecute();
            }
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_UndoActionPerformed

    private void UndoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UndoKeyPressed
    
         try{
        if(evt.getSource()==Undo)
        {   Command un=StackOfCommands.removeCommand();
            un.unexecute();
            }
        }
        catch(Exception e)
        {}
    
    }//GEN-LAST:event_UndoKeyPressed

    private void italicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicActionPerformed
        // TODO add your handling code here:
        font1=(String)FontStyle.getSelectedItem();
          fontsize=Integer.parseInt((String)(Size.getSelectedItem()));
          
       if(evt.getSource()==italic)
           {  if(italic.isSelected())
           { textArea.setFont(new Font(font1,Font.ITALIC,fontsize));
    
           }
           else 
           {textArea.setFont(new Font(font1,Font.PLAIN,fontsize));
            }
           }
    }//GEN-LAST:event_italicActionPerformed
    
     
    
    
   
    
  
    
    
    public void finalExecuter()
    {
        StackOfCommands.getTop().execute();
                
   
    }
    
    
    
    
    
   
    public static void main(String args[]) throws Exception{
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.getLookAndFeelDefaults();
               try{
                new demo().setVisible(true);
                new demo().textArea.setRequestFocusEnabled(true);
               }
               catch(Exception e)
               {}
      
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Color1;
    private javax.swing.JComboBox<String> FontStyle;
    private javax.swing.JMenu OPen;
    private javax.swing.JComboBox<String> Size;
    private javax.swing.JButton Undo;
    private javax.swing.JRadioButton bold;
    private javax.swing.JMenuItem exit;
    private javax.swing.JRadioButton italic;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem save;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    
}


           
           
           
           
           
