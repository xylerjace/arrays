import java.util.Scanner;
class MyArray{

    int size,index;
    int[] arr;

    MyArray(int size){
        this.size = size;
        arr = new int[size];
        index = -1;

    }
    public int count(){
        int count = 0;
        for(int i= 0; i< arr.length; i++){
            if(arr[i] != 0){
                count++;
            }
        }
        return count;
    }
    public boolean isFull(){
        return count() >= size;
    }


    public boolean isEmpty(){
        return count() == 0;
    }

    public void add(int value){
        if(!isFull()){
            arr[++index] = value;
            count();
        }else{
            System.out.println("Array is full");
        }
    }

    public void view(){
        if(!isEmpty()){
            for(int i = 0; i < arr.length;i++){
             System.out.print("["+ arr[i] +"]");
            }
        }else{
            System.out.println("\nThere are no values added!! Try again\n");
        }
    }

    public void remove(int value){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]== value){
                arr[i] = 0;
                count();
            }
        }
    }

    public int search(int value){
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
    
    public void edit(int ind, int value){
        arr[ind] = value;
    }

    public void sort(int ch){
        //ascending order
        if(ch == 1){
            for(int i = 0; i < arr.length - 1; i++){
                int min = i;
                for(int j = i + 1; j < arr.length;j++){
                    if(arr[min]> arr[j]){
                        min = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        if(ch == 2){
            for(int i = 0; i < arr.length - 1; i++){
                int min = i;
                for(int j = i + 1; j < arr.length;j++){
                    if(arr[min] < arr[j]){
                        min = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}

public class Arrays{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Array size: ");
        int size = scan.nextInt();
        MyArray array = new MyArray(size);

        while(true){
            System.out.println("\nWhat do you want to do?");
            System.out.println("[1]Add\n[2]View\n[3]Remove\n[4]Search\n[5]Sort\n[6]Edit\n[7]Exit");
            int choice = scan.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to add: ");
                     int value = scan.nextInt();
                    array.add(value);
                    array.view();
                    break;
                case 2: array.view();break;
                case 3:
                    array.view();
                    System.out.println("\nEnter value to remove: ");
                    int removeValue = scan.nextInt();
                    array.remove(removeValue);  
                    array.view();
                    break;
                case 4: 
                    array.view();
                    System.out.println("\nWhat value do you want to search:");
                    int searchValue = scan.nextInt();
                    System.out.println("Your value is on index: "+ array.search(searchValue));
                    break;
                case 5:
                    array.view();
                    System.out.println("\nWhat way do you want to sort:");
                    System.out.println("[1]Ascending order\n[2]Descending order");
                    int ch = scan.nextInt();
                    array.sort(ch);
                    array.view();
                    break;
                case 6:
                    array.view();
                    System.out.print("\nWhat index do you want to edit: ");
                    int ind = scan.nextInt();
                    System.out.print("\nWhat is your new value: ");
                    int editValue = scan.nextInt();
                    array.edit(ind, editValue);
                    break;

                case 7: 
                    System.out.println("Thank you for using!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That number is invalid,please try again");
            }
        }
    }
}