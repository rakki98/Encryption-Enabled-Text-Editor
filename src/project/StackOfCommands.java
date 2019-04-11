
package project;

public class StackOfCommands {
    static Command[] stack=new Command[1000];
    static int top=-1;

     public StackOfCommands() {
    }
    
     static Command addCommand(Command newCommand)
    {
        stack[++top]=newCommand;
        return stack[top];
    }
    static Command removeCommand() throws Exception
     {
       if(top!=-1)
       {
          return stack[top--];
       }
       return null;
     }
    
    
    static Command getTop()
    {
      if(top!=-1)
       {
          return stack[top];
       }
       return null;

     }
    
    
    
}
