package org.actlab.msat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"org.actlab.msat"})
@SpringBootApplication
public class MsatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsatApplication.class, args);
	}

}
