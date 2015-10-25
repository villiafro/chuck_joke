package is.arnlaugsson.chuck_joke;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;


public class Chuck {

    final ICNDBClient client = new ICNDBClient();

    public String random() {
        Joke randomJoke = client.getRandom();
        return randomJoke.getJoke();
    }
}
