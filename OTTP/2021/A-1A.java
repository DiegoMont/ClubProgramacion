import java.util.Scanner;

class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for(; t > 0; t--){
      String a = sc.nextLine();
      int n = a.length();
      if(a.charAt(0) == a.charAt(n-1)){
        System.out.println("NO");
        continue;
      }
      int[] countChars = new int[3];
      for(int i = 0; i < n; i++){
        char letra = a.charAt(i);
        countChars[letra-65]++;
      }
      char[] equivalencias = new char[3];
      equivalencias[a.charAt(0)-65] = '(';
      equivalencias[a.charAt(n-1)-65] = ')';
      for(int i = 0; i < 3; i++){
        if(equivalencias[i] == 0){
          if(countChars[a.charAt(0)-65] > countChars[a.charAt(n-1)-65])
            equivalencias[i] = ')';
          else
            equivalencias[i] = '(';
        }
      }
      int contador = 0;
      for(int i = 0; i < n; i++){
        char letra = a.charAt(i);
        if(equivalencias[letra-65] == '(')
          contador++;
        else
          --contador;
        if(contador < 0)
          break;
      }
      System.out.println((contador == 0 ? "YES": "NO"));
    }
  }
}