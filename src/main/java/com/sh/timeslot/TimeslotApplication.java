package com.sh.timeslot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
@EnableCaching
public class TimeslotApplication {

    public static void main(String[] args) throws UnknownHostException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        log.info("Start core application ...");
        SpringApplication app = new SpringApplication(TimeslotApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t"
                        + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles());
    }

}

