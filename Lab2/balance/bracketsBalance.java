/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <exp>
 *  
 *  by Jeff Souza
 *
 */
//Riley de Domenico - 300016694

class bracketsBalance {

    private boolean bBalance (String exp){ 
      ArrayStack stk = new ArrayStack(10);
      String brackets = "(){}[]";
      for (int i = 0; i < exp.length(); i++){
        char charac = exp.charAt(i);
        int input = brackets.indexOf(charac);
        if (input % 2 == 0){
          try{
            stk.push(new Character (charac));
          }
          catch(StackFullException e){
          }
        }
        else if (input != -1){
          if (stk.isEmpty())
            return false;
          char fs = '\0';
          try{
            fs = ((Character)stk.pop()).charValue();
          }
          catch(StackEmptyException e){
          }
          int stackPos = brackets.indexOf(fs);
          if(stackPos+1 != input)
            return false;
        }
      }
        return stk.isEmpty();

    }

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance(args[0]);
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}