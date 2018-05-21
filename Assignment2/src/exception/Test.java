package exception;

public class Test {
	public static void main(String[] args)
    { 
        TestException te = new TestException();
      
        try{
            te.test();
  	  }
  	  catch(Exception e){
            System.err.println(e.getMessage());
  	  }
    }

}
