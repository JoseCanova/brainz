package org.nanotek.brainzshell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.jline.PromptProvider;

 
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"org.nanotek" , "org.nanotek.brainz","org.nanotek.brainzshell"})
@CommandScan
public class BrainzShellMain {

	public static void main(String[] args) {
		SpringApplication.run(BrainzShellMain.class, args);
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("my-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}
}