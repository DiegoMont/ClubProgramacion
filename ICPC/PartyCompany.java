import java.util.Scanner;
import java.util.LinkedList;

public class PartyCompany {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt(); sc.nextLine();
    Empleado[] empleados = new Empleado[n];
    for (int i = 0; i < n; i++){
      int age = sc.nextInt(), manager = sc.nextInt(); sc.nextLine();
      empleados[i] = new Empleado(age, manager-1);
    }
    for (int i = 0; i < n; i++){
      if(empleados[i].manager != i){
        empleados[empleados[i].manager].subordinates.add(i);
      }
    }
    //Para cada fiesta}
    for (int j = 0; j < m; j++) {
      int owner = sc.nextInt(), min = sc.nextInt(), max = sc.nextInt(); sc.nextLine();
      LinkedList<Integer> fila = new LinkedList<>();
      fila.push(owner-1);
      boolean[] visitados = new boolean[n];
      while (!fila.isEmpty()) {
        int act = fila.poll();
        empleados[act].parties++;
        visitados[act] = true;
        int managersAge = empleados[empleados[act].manager].age;
        if (empleados[act].manager != act && managersAge >= min && managersAge <= max && !visitados[empleados[act].manager]) {
          fila.push(empleados[act].manager);
        }
        //Añadir a los subordinados
        for (int indexSubordinate : empleados[act].subordinates) {
          int subordinateAge = empleados[indexSubordinate].age;
          if(subordinateAge >= min && subordinateAge <= max && !visitados[indexSubordinate])
            fila.push(indexSubordinate);
        }
      }
    }

    for (Empleado empleado : empleados) {
      System.out.print(empleado.parties+" ");
    }
    System.out.println("");
  }

}

class Empleado {
  int age, manager, parties;
  LinkedList<Integer> subordinates;
  public Empleado(int age, int manager){
    this.age = age;
    this.manager = manager;
    parties = 0;
    subordinates = new LinkedList<>();
  }
}