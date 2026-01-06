package io.github.gustavosrosa.libraryapi;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(LibraryapiApplication.class);
		
		springApplicationBuilder.bannerMode(Mode.OFF);
		springApplicationBuilder.run(args);
	}

}
