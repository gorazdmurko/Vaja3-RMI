
// SERVICE
package si.academia.unit29.vaja3.svc;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import si.academia.unit29.vaja3.itf.Author;
import si.academia.unit29.vaja3.itf.IAuthorService;

import java.io.File;
import java.io.IOException;
// import java.rmi.RemoteException;
// import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class AuthorService implements IAuthorService {

    private Dictionary<String, Author> authors = new Hashtable<String, Author>();    // Dictionary<> => Hashtable<T>(), HashMap<T>()

   public AuthorService() {
        //super();
        // try {
        //     UnicastRemoteObject.exportObject(this, 0);
        // } catch (RemoteException e) {
        //     e.printStackTrace();
        // }
    }


    @Override
    public void createAuthor(Author author) { authors.put(author.getName(), author); }      // key (name), value (object - author)
    @Override
    public void deleteAuthor(String name) { authors.remove(name); }     // removes by key (name), not value
    @Override
    public Author getAuthor(String name) { return authors.get(name); }  // calls by key & returns value
    @Override
    public List<Author> getAuthors() { return new ArrayList<Author>(((Hashtable<String, Author>)authors).values()); }

    @Override
    public void save(String path) throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        objMap.enable(SerializationFeature.INDENT_OUTPUT);
        objMap.writeValue(new File(path), authors);
    }
    @Override
    public void load(String path) throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        authors = objMap.readValue(new File(path), new TypeReference<Hashtable<String, Author>>() {});
    }

    @Override
    public void test(Author a1, Author a2) {
        if (a1 != a2) {
            System.out.println("\ntest failed: ERROR occured --> " + a1.getName() + " not equal to " + a2.getName());
        } else {
            System.out.println("\ntest passed succesfully --> " + a1.getName() + " = " + a2.getName());
        }
    }
}
