package School.IMK;

import java.util.*;

// here lies the algorithms
public class ListAll {
    ArrayList<String> listInput = new ArrayList<String>();
    ArrayList<Boolean> listChecker = new ArrayList<Boolean>();

    public void addList(String input){
        listInput.add(input);
        listChecker.add(false);

        System.out.println("created! list #" + listInput.size());
    }

    public void removeList(int n){
        listInput.remove(n-1);
        listChecker.remove(n-1);

        System.out.println("list #" + n + " removed.");
    }

    public void markList(int n){
        if (listChecker.get(n-1) == true) {
            listChecker.set(n-1, false);

            System.out.println("list #" + n + " unmarked!");
        } else{
            listChecker.set(n-1, true);

            System.out.println("list #" + n + " marked!");
        }
    }

    public void checkList(){
        int counter = 0;

        for (String temp : listInput) {
            System.out.print("#" + (counter + 1) + ". " + temp); 
            System.out.println(" - " + listChecker.get(counter));

            counter++;
        }
    }

    // main
    public static void main(String[] args) {
        ListAll list = new ListAll();
        Commands command = new Commands();

        Scanner sc = new Scanner(System.in);

        // opening output w/ input
        command.splitter(); command.intro(); command.help(); command.stuff(); command.insert();
        String input1 = sc.nextLine();

        // run until exit
        while (input1.equalsIgnoreCase("exit") == false){
            command.splitter();

            // add
            if (input1.equalsIgnoreCase("add")){
                command.add();
                String input2 = sc.nextLine();
                command.splitter();

                if (input2.equalsIgnoreCase("one")){
                    command.addOnce();

                    list.addList(sc.nextLine()); command.splitter();
                } else if (input2.equalsIgnoreCase("two")){
                    command.addMultiple();
                    int n = sc.nextInt(); String bugCatcher = sc.nextLine(); // important because some stupid bug or smth idfk
                    command.splitter();
                
                    for (int temp = 0;temp < n;temp++){
                        command.addOnce();

                        list.addList(sc.nextLine()); command.splitter();
                    }
                } else command.miss();

            // remove
            } else if (input1.equalsIgnoreCase("remove")){
                command.remove();
                String input2 = sc.nextLine();
                command.splitter();

                if (input2.equalsIgnoreCase("one")){
                    command.removeOnce();

                    list.removeList(sc.nextInt()); command.splitter();
                    String bugCatcher = sc.nextLine(); // important because some stupid bug or smth idfk
                } else if (input2.equalsIgnoreCase("two")){
                    command.removeMultiple();
                    int n = sc.nextInt(); String bugCatcher = sc.nextLine(); // important because some stupid bug or smth idfk
                    command.splitter();
                
                    for (int temp = 0;temp < n;temp++){
                        command.removeOnce();

                        list.removeList(sc.nextInt()); command.splitter();
                        String bugCatcher2 = sc.nextLine(); // important because some stupid bug or smth idfk
                    }
                } else command.miss();

            // mark
            } else if (input1.equalsIgnoreCase("mark")){
                command.mark();
                String input2 = sc.nextLine();
                command.splitter();

                if (input2.equalsIgnoreCase("one")){
                    command.markOnce();

                    list.markList(sc.nextInt()); command.splitter();
                    String bugCatcher = sc.nextLine(); // important because some stupid bug or smth idfk
                } else if (input2.equalsIgnoreCase("two")){
                    command.markMultiple();
                    int n = sc.nextInt(); String bugCatcher = sc.nextLine(); // important because some stupid bug or smth idfk
                    command.splitter();
                
                    for (int temp = 0;temp < n;temp++){
                        command.markOnce();

                        list.markList(sc.nextInt()); command.splitter();
                        String bugCatcher2 = sc.nextLine(); // important because some stupid bug or smth idfk
                    }
                } else command.miss();

            // list the to-do lists (lol)
            } else if (input1.equalsIgnoreCase("check")){
                command.show(); list.checkList(); command.splitter();

            // help
            } else if (input1.equalsIgnoreCase("help")){
                command.help();;

            // wrong command or return to 'home'
            } else command.miss();

        command.insert(); 
        input1 = sc.nextLine();
        }

        command.exit(); command.splitter();

        sc.close();
    }
}

// texts
final class Commands{
    private String add, remove, mark, change, check, help, exp, imp, exit;

    public void splitter(){
        System.out.println("=--------------------------------------------------------------------------------------------------------=");
    }

    public void stuff(){
        System.out.printf("hey this is uploaded to my school github so I can play around here again later (probably): https://github.com/itsgusyudis\n\n");
    }

    public void insert(){
        System.out.print("please type your option: ");
    }

    public void intro(){
        System.out.println("welcome to ToDoList! like the name says, this is a program made for managing your to-do list.");
        System.out.printf("for starters, please select one of these options to start things off:\n\n");
    }

    public void add(){
        System.out.println("do you want to add one list or multiple at once? (hey, in case you want to go back, type anything but the options below)");
        System.out.printf("options are 'one' for one list, 'two' for multiple.\n\n");
        System.out.print("type your option here: ");
    }

    public void addOnce(){
        System.out.print("please type your to-do list: ");
    }

    public void addMultiple(){
        System.out.print("please type how much do you want to add: ");
    }

    public void remove(){
        System.out.println("do you want to remove one list or multiple at once? (remember to recognize the list location/s!! in case you want to go back, type anything but the options below)");
        System.out.printf("options are 'one' for one list, 'two' for multiple. (yes this is a copy of the 'add' wording)\n\n");    
        System.out.print("type your option here: ");
    }

    public void removeOnce(){
        System.out.print("please type your to-do list location to be removed: ");
    }

    public void removeMultiple(){
        System.out.print("please type how much do you want to remove: ");
    }

    public void change(){
        System.out.println("do you want to change one list or multiple at once? (remember to recognize the list location/s!! in case you want to go back, type anything but the options below)");
        System.out.printf("options are 'one' for one list, 'two' for multiple. (yes this is a copy of the 'add' wording)\n\n");    
        System.out.print("type your option here: ");
    }

    public void changeOnce(){
        System.out.print("please type your to-do list location to be changed: ");
    }

    public void changeMultiple(){
        System.out.print("please type how much do you want to change: ");
    }

    public void mark(){
        System.out.println("do you want to mark/unmark one list or multiple at once? (remember to recognize the list location/s!! in case you want to go back, type anything but the options below)");
        System.out.printf("options are 'one' for one list, 'two' for multiple. (yes this is a copy of the 'add' wording)\n\n");    
        System.out.print("type your option here: ");
    }

    public void markOnce(){
        System.out.print("please type your to-do list location to be marked/unmarked: ");
    }

    public void markMultiple(){
        System.out.print("please type how much do you want to mark/unmark: ");
    }

    public void show(){
        System.out.println("here's all your current to-do list:");
    }

    public void help(){
        add = "add -> adds a to-do list to your file. by default, it will be unmarked (not completed) by default";
        remove = "remove -> remove a to-do list at certain location (make sure to check the location by typing 'check' first)";
        mark = "mark -> mark a to-do list to be completed (or vice versa)";
        change = "change -> change a to-do list to something else";
        check = "check -> lists all of your to-do list right on the terminal";
        help = "help -> all the commands you need in life (in this case ToDoList)";
        exit = "exit -> end the program";
        exp = "exp -> exporting the to-do list to a .txt file (TO BE ADDED AS SIDE PROJECT IN THE FUTURE)";
        imp = "imp -> importing a .txt file to the program (TO BE ADDED AS SIDE PROJECT IN THE FUTURE)";

        System.out.printf("- %s\n- %s\n- %s\n- %s\n- %s\n- %s\n- %s\n- %s\n- %s\n\n", add, remove, mark, change, check, help, exp, imp, exit);
    }

    public void miss(){
        System.out.println("did you mistype? that command doesn't exist.");
        System.out.printf("in case you forget, type 'help' for all the commands!\n\n");
    }

    public void exit(){
        System.out.println("program exited. thanks for the time.");
    }
}
