ackage org.scheduler;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static Scheduler Read(String path){
        Scheduler escalonador;

        try {
            escalonador = new Gson().fromJson(new FileReader(path), Scheduler.class);

            for (int i = 0; i < escalonador.tasks.length; i++) { escalonador.tasks[i].setIndex(i); }

            return escalonador;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
