package org.nanotek.brainz.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class NioKongStreamBuilder implements Stream.Builder<String> {
	
	private Stream<String> fileStream;
	private String fileName;
	
	public NioKongStreamBuilder(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void accept(String t) {
	}

	@Override
	public Stream<String> build() {
		try {
			 fileStream = Files.lines(Paths.get(fileName));
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return fileStream;
	}

	public static void main(String [] args) {
	Flux<String> flux =	Flux.fromStream(new NioKongStreamBuilder("/home/jose/Downloads/mbdump/mbdump/area").build());
	//Mono<String> theMono = flux.elementAt(100);
	flux.subscribe(s -> System.out.println(s));
	}
}
