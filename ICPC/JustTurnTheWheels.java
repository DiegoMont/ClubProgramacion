import java.util.Scanner;

class J {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for (int caso = 0; caso < t; caso++){
      int c = sc.nextInt(), f = sc.nextInt(), b = sc.nextInt(), s = sc.nextInt(); sc.nextLine();
      int gradosFrontal = 360%f == 0 ? 360/f: 360;
      int gradosTrasera = 360%b == 0 ? 360/b: 360;
      int minGradosFrontal = MCM(gradosFrontal, 30);
      int minGradosTrasera = MCM(gradosTrasera, 30);
      int vueltasParaQuedarParejas = MCM(minGradosFrontal, minGradosTrasera) / 30;
      double vueltasParaCubrirDistancia = 12.0 * s / c;
      long resultado;
      if(vueltasParaQuedarParejas >= vueltasParaCubrirDistancia)
        resultado = vueltasParaQuedarParejas;
      else
        resultado = (long) (Math.ceil(vueltasParaCubrirDistancia / vueltasParaQuedarParejas) * vueltasParaQuedarParejas);
      System.out.println(resultado);
    }
    sc.close();
  }

  private static int MCM(int a, int b){
    return a * b / MCD(a, b);
  }

  private static int MCD(int a, int b){
    return MCDRecursivo(Math.max(a, b), Math.min(a, b));
  }

  private static int MCDRecursivo(int a, int b){
    int residuo = a%b;
    if(residuo == 0)
      return b;
    else
      return MCDRecursivo(b, residuo);
  }
}
