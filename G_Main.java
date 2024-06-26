import G_models.Contact;
import G_models.ContactManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class G_Main {

    static ContactManager manager = new ContactManager();

    public static void main(String[] args){
        try {
            //"C:\Users\kamir faruk\IdeaProjects\Bookcamp\out\production\Bookcamp\Gcontacts.txt"
            loadContacts("C:\\Users\\kamir faruk\\IdeaProjects\\Bookcamp\\out\\production\\Bookcamp\\Gcontacts.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Contacts Loaded\n\n");
            System.out.println(manager);
            manageContacts();
        }

        //try {
            //testing objectContact
            //Contact contact0 = new Contact("Kami gumi", "7732567568", "08/23/1945");
            //System.out.println(contact0);

            //testing setters
            //contact.setBirthDate("08/18/1900");
            //System.out.println(contact.getBirthDate());

            //testing source
            //Contact contact1 = new Contact("Kami Runi", "7732567568", "08/23/1945");
            //Contact contact2 = new Contact(contact);
            //System.out.println(contact2);

            //testing contact manager
            //ContactManager manager = new ContactManager();
            //manager.addContact(new Contact("reayees","7489759868","11/01/1993"));
            //manager.addContact(new Contact("Giovanii","7483876986","08/11/1993"));
            //manager.addContact(new Contact("favi","7483497868","11/11/1903"));
            //manager.removeContact("favi");
            //    System.out.println(manager);
        //}catch(ParseException e){
            //System.out.println(e.getMessage());
        //}finally{
            //System.out.println("Process Complete");
        //}



    }


    //  function Name: loadContacts()
    //          @param fileName (String)
    //          @throws FileNotFoundException
    //  Inside the function:
    //        1. loads contacts from <fileName>;
    //        2. From the manager object, it adds all contacts to the contacts list.
    //        Hint: use scan.next to grab the next String separated by white space.

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fil = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fil);

        while(scanFile.hasNextLine()){

            try {
                Contact contact = new Contact(scanFile.next(), scanFile.next(), scanFile.next());
                manager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        scanFile.close();
    }


    //Name: manageContacts
    //Inside the function:
    //1. Starts a new instance of Scanner;
    //2. In an infinite loop, the user can choose to a) add b) remove c)exit
    //case a: ask for the name, phone number and birthDate
    //case b: ask who they'd like to remove.
    //case c: break the loop.
    //3. close Scanner.

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to \n\tA) Add Contact\n\tB) Remove Contact\n\tC) Exit");
            String response = scan.nextLine();
            if(response.equals("a")){
                System.out.println("\tName: ");
                String name = scan.nextLine();
                System.out.println("\tPhone Number: ");
                String phoneNumber = scan.nextLine();
                System.out.println("\tBirthDate: ");
                String birthDate = scan.nextLine();
                if (name.isBlank()||phoneNumber.isBlank()){
                    System.out.println("\nRegistration Failed! \nInvalid Input Name or phone Number is missing! ");
                }else{
                    try {
                        manager.addContact(new Contact(name,phoneNumber,birthDate));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());;
                    }finally {
                        System.out.println("CONTACTS UPDATED\n"+manager);
                    }
                }

            } else if (response.equals("b")) {
                System.out.println("\nWho would you like to remove? ");
                try {
                    manager.removeContact(scan.nextLine());
                } finally {
                    System.out.println("CONTACTS UPDATED\n"+manager);
                }

            } else{
                break;
            }


        }
        scan.close();
    }
}
