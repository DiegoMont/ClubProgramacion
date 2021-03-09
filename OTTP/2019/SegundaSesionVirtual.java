import java.util.Scanner;

class SegundaSesion {

  public static void main(String[] args) {
    problemaA();
  }

  public static void problemaA(){
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    while (true) {
      int casos = sc.nextInt();sc.nextLine();
      if (casos > 0) {
        int resultado = 0;
        for (int i = 0; i < casos; i++) {
          resultado += sc.nextInt();
          resultado -= sc.nextInt(); sc.nextLine();
        }
        if (resultado == 0) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      } else {break;}
    }
    sc.close();
  }

  public static void problemaB(){
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int casos = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < casos; i++) {
      int[] datos = new int[4];
      for (int j = 0; j < 4; j++) {
        datos[j] = sc.nextInt(); // L v l r
      }
      sc.nextLine();
      int lamparas = (int)Math.floor(datos[0]/datos[1]);
      lamparas -= (int)Math.floor((datos[3]-datos[2]+1)/datos[1]);
      if (Math.ceil(1.0*datos[2]/datos[1])*datos[1] <= (datos[3]-datos[2]+1)%datos[1]+datos[2]-1) {
        System.out.print(Math.ceil(datos[2]/datos[1])+" ");
        lamparas--;
      }
      System.out.println(lamparas);
    }
    sc.close();
  }

}
