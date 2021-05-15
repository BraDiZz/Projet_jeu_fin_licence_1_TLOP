/**
* Classe CustomSerializeObject, utilisée pour serializer et déserializer tout type d'objets. (Utilisée dans
* MainSwing et MaiNFX dans ce cas là)
* @author DIOT Sébastien
* @version 16/05/2021
*/
package save;

import java.io.*;

public class CustomSerializeObject {
    /**
    * Methode utilisee pour serialiser un objet.
    * @param object l'objet à serialiser.
    * @param fileName nom du fichier pour la serialisation.
    */
    public static void serialize(Object object, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./" + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    /**
    * Méthode utilisee pour deserialiser un objet.
    * @param fileName nom du fichier à deserialiser
    * @return l'objet deserialise
    */
    public static Object deserialize(File file) {
        Object ret = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ret = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return(ret);
    }
}