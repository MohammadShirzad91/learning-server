package com.example.learningserver.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;

@Component
public class MyWriter implements ItemWriter<String> {
    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        System.out.println("write ...");
        File file = new File("D:\\JavaProjects\\learning-server\\card.json");
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, chunk.getItems());
        outputStream.close();
    }
}
