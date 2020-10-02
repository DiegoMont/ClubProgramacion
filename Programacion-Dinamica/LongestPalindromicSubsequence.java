public class LongestPalindromicSubsequence {
  public static void main(String[] args){
    String palabra = "ABBDCACB";
    /*palabra = "CADA";
    palabra = "CABDA";*/
    //palabra = "B";
    System.out.println(LPS(palabra, 0, palabra.length()-1));
    System.out.println(LPSDynamic(palabra, 0, palabra.length()-1, new String[palabra.length()][palabra.length()]));
  }

  public static String LPSDynamic(String palabra, int inicio, int fin, String[][] tablita){
    if(fin < inicio){
      return "";
    }
    if (tablita[inicio][fin] != null) {
      return tablita[inicio][fin];
    }
    String palindromo;
    if(fin == inicio){
      palindromo = Character.toString(palabra.charAt(inicio));
    } else if(palabra.charAt(inicio) == palabra.charAt(fin)){
      palindromo = palabra.charAt(inicio) + LPS(palabra, inicio+1, fin-1) + palabra.charAt(fin);
    } else {
      String opcion1 = LPS(palabra, inicio + 1, fin);
      String opcion2 = LPS(palabra, inicio, fin - 1);
      int len1 = opcion1.length(), len2 = opcion2.length();
      if(len1 > len2)
        palindromo = opcion1;
      else
        palindromo = opcion2;
    }
    tablita[inicio][fin] = palindromo;
    return tablita[inicio][fin];
  }
  
  public static String LPS(String palabra, int inicio, int fin){
    if(fin < inicio){
      return "";
    } else if(fin == inicio){
      return Character.toString(palabra.charAt(inicio));
    } else if(palabra.charAt(inicio) == palabra.charAt(fin)){
      return palabra.charAt(inicio) + LPS(palabra, inicio+1, fin-1) + palabra.charAt(fin);
    } else {
      String opcion1 = LPS(palabra, inicio + 1, fin);
      String opcion2 = LPS(palabra, inicio, fin - 1);
      int len1 = opcion1.length(), len2 = opcion2.length();
      if(len1 > len2)
        return opcion1;
      else
        return opcion2;
    }
  }
}
