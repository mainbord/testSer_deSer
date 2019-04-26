package com.example.del;

import lombok.SneakyThrows;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping
public class Controller {


    private final String MODEL_FILE = "/home/jul/model_object";

    @SneakyThrows
    @GetMapping(value = "/create")
    public void writeString() {
        Model model = new Model();
        model.setI1(1);
        model.setS1("ss");

        Files.write(Paths.get(MODEL_FILE), SerializationUtils.serialize(model));
    }


    @SneakyThrows
    @GetMapping(value = "/read")
    public Model getString() {
        Model model = new Model();
        model.setI1(1);
        model.setS1("ss");
        return (Model) SerializationUtils.deserialize(Files.readAllBytes(Paths.get(MODEL_FILE)));
    }

}
