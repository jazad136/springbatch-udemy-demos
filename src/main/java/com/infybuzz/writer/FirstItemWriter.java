package com.infybuzz.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class FirstItemWriter implements ItemWriter<Long> {

	@Override
	public void write(Chunk<? extends Long> items) throws Exception {
		System.err.println("Inside Item Writer");
		items.forEach(System.err::println);
	}
//	@Override
//	public void write(List<? extends Long> chunk) throws Exception {
//		
//	}

}
