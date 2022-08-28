// SERVER

package si.academia.unit29.vaja3.srv;

import si.academia.unit29.vaja3.itf.Author;
import si.academia.unit29.vaja3.itf.Book;
import si.academia.unit29.vaja3.itf.IAuthorService;
import si.academia.unit29.vaja3.svc.AuthorService;

// import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ServerMain {

    // server -> creates registry (phonebook) & the server OBJECT is put into the registry
    //        -> server must implement a special interface
    //        -> server exports UnicastRemoteObject
    // client -> contacts the registry, lookup at what it needs (from phonebook) & receives a stub interface that represents the server object
    //        -> it can now call the methods on the server object (remotely)

    public static void main(String[] args) throws RemoteException {

        // 1. remote object ( remote implementation )
        IAuthorService svc = createServiceObject(new AuthorService());

        try {
            // 2. create a stub of remote object -> stub is representation of remote object
            IAuthorService stub = (IAuthorService) UnicastRemoteObject.exportObject(svc, 0);

            // 3. create registry
            final Registry rmiReg = LocateRegistry.createRegistry(1099);

            // 4. bind stub (representation of remote object ) to RMI registry
            rmiReg.bind("AuthorService", stub);
            System.out.println("\nServer ready!");

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        System.out.println("Shutting down server...");
                        rmiReg.unbind("AuthorService");
                        System.out.println("Server disconnected");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (NotBoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private static IAuthorService createServiceObject(IAuthorService service) throws RemoteException {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Kajetan Kovic", "Mladinska Knjiga", new GregorianCalendar(1999, 2, 6).getTime(), 110));
        Author author = new Author("Kajetan Kovic", 87, false, bookList);
        service.createAuthor(author);
        return service;
    }
}

// 1. CLIENT
// Registry rmiReg = LocateRegistry.getRegistry(null);     // local computer
// IAuthorService svc = (IAuthorService) rmiReg.lookup("AuthorService");

// 2. SERVER
// AuthorService svc = new AuthorService();
// IAuthorService stub = (IAuthorService) UnicastRemoteObject.exportObject(svc, 0);
// Registry rmiReg = LocateRegistry.getRegistry();
// rmiReg.bind("AuthorService", stub);