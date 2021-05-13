/**
* Classe CustomSerializeObject, utilisée pour serializer et déserializer tout type d'objets. (Utilisée dans
* MainSwing et MaiNFX dans ce cas là)
* @author DIOT Sébastien
* @version 10/05/2021
*/

package save;

import java.io.*;

public class CustomSerializeObject {
    /**
    * Méthode utilisée pour sérialiser un objet.
    * @param object l'objet à sérialiser.
    * @param fileName nom du fichier pour la sérialisation.
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
    * Méthode utilisée pour déserialiser un objet.
    * @param fileName nom du fichier à déserialiser
    * @return l'objet déserialisé
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