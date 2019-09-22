//Demosntra ByteArrayOutputStream
//Este programa usa try-with-resources


package application;

import java.io.*;

public class byteArrayOutputStreamDemo {

  public static void main(String[] args) {
   
    ByteArrayOutputStream f = new ByteArrayOutputStream();
    String s = "Isto deverá ir para o o array";
    byte buf[] = s.getBytes(); //buffer
    
    try {
      f.write(buf);
    }
    catch (IOException e) {
      System.out.println("Erro escrevendo buffer");
      return; 
    }
    
    System.out.println("Buffer com um string");
    System.out.println(f.toString());
    System.out.println("No array");
    byte b[] = f.toByteArray();
    
    for(int i =0; i<b.length; i++) {
      System.out.print((char) b[i]);
    }
    
    System.out.println("\nPara um OutputStream()");
    
    //Usa try-with-resources para gerenciar o fluxo do arquivo.
    try(FileOutputStream f2 = new FileOutputStream("test.txt")){
      f.writeTo(f2);
    }
    catch (IOException e) {
      System.out.println("Error de I/o:" + e.getMessage());
      return;
    }
    
    System.out.println("Fazendo o reset");
    f.reset();
    
    for(int i=0; i<3; i++) {
      f.write('X');
    }
    System.out.println(f.toString());

  }

}
