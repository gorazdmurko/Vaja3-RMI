package si.academia.unit29.vaja3.client;

import si.academia.unit29.vaja3.itf.Author;
import si.academia.unit29.vaja3.itf.Book;
import si.academia.unit29.vaja3.itf.IAuthorService;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

// https://mkyong.com/java/java-rmi-hello-world-example/
// https://www.baeldung.com/java-rmi

public class AppMain {

    public static void main(String[] args) {

        // 1. -> preko RMI registra pridi do IAuthorService oddaljenega API-ja
        // 2. -> dodaj 2 avtorja & 1 knjigo
        // 3. -> prek getAuthors() pridobi vse avtorje in jih izpisi v konzolno okno

        try {
            // creating the client
            Registry rmiReg = LocateRegistry.getRegistry("localhost", 1099);     // local computer
            IAuthorService svc = (IAuthorService) rmiReg.lookup("AuthorService");

            List<Book> auth1BookList = new ArrayList<Book>();
            auth1BookList.add(new Book("DaVinci's Code", "Brown", new GregorianCalendar(1999, 2, 6).getTime(), 277));
            Author author1 = new Author("Dan Brown", 67, true, auth1BookList);
            svc.createAuthor(author1);

            Book book = new Book("Secrets of S. J.", "Jobs", new GregorianCalendar(2009, 11, 3).getTime(), 321);
            List<Book> auth2BookList = new ArrayList<Book>();
            auth2BookList.add(book);
            Author author2 = new Author("Steve Jobs", 58, false, auth2BookList);
            svc.createAuthor(author2);

            // String pathName = IAuthorService.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "service.json";
            String path = "Vaja3-RmiClient\\";
            path += "jsonFiles\\service.json";
            svc.save(path);

            List<Author> authors = svc.getAuthors();
            System.out.println("\nAuthors => " + authors.toString());
            System.out.println("\n\nAuthor[Dan Brown] => " + svc.getAuthor("Dan Brown"));
            System.out.println("Author[Steve Jobs] => " + svc.getAuthor("Steve Jobs"));
            System.out.println("Author[Kajetan Kovic] => " + svc.getAuthor("Kajetan Kovic"));

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
