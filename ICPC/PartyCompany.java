import java.util.Scanner;
import java.util.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;

public class PartyCompany {
  public static void main(String[] args) throws FileNotFoundException{
    //Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new File("input.txt"));
    int n = sc.nextInt(), m = sc.nextInt(); sc.nextLine();
    Empleado[] empleados = new Empleado[n];
    for (int i = 0; i < n; i++){
      int age = sc.nextInt(), manager = sc.nextInt(); sc.nextLine();
      empleados[i] = new Empleado(age, manager-1, i);
    }
    for (int i = 0; i < n; i++){
      if(empleados[i].manager != i){
        empleados[empleados[i].manager].subordinates.add(i);
      }
    }
    calculateSubordinates(empleados, 0);
    System.out.println(empleados[0].numSubordinados);
    //Para cada fiesta}
    for (int j = 0; j < m; j++) {
      int owner = sc.nextInt(), min = sc.nextInt(), max = sc.nextInt(); sc.nextLine();
      
    }

    for (Empleado empleado : empleados) {
      System.out.print(empleado.parties+" ");
    }
    System.out.println("");
  }

  private static void calculateSubordinates(Empleado[] empleados, int empleadoId) {
    empleados[empleadoId].numSubordinados += empleados[empleadoId].subordinates.size();
    for (int index : empleados[empleadoId].subordinates) {
      Empleado subordinado = empleados[index];
      calculateSubordinates(empleados, subordinado.id);
      empleados[empleadoId].numSubordinados += subordinado.numSubordinados;
    }
  }

}

class Empleado {
  int age, manager, parties, numSubordinados, id;
  LinkedList<Integer> subordinates;
  public Empleado(int age, int manager, int id){
    this.age = age;
    this.manager = manager;
    parties = 0;
    numSubordinados = 0;
    subordinates = new LinkedList<>();
    this.id = id;
  }
}