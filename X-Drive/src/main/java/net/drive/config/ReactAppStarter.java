package net.drive.config;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ReactAppStarter implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startReact();
    }

    public void startReact() throws IOException {
        String reactAppPath = "C:\\Users\\ahmet\\Desktop\\workspace\\develop\\reactui";

        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\nodejs\\npm.cmd", "start");

        processBuilder.directory(new File(reactAppPath));
        processBuilder.inheritIO(); // für Logs
        processBuilder.start();
    }
}
