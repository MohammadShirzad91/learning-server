package com.example.learningserver.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

@Component
public class MyWriter implements ItemWriter<String> {
    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        File file = new File("D:\\JavaProjects\\learning-server");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(chunk.getItems().toString().getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
}
