package pl.Quantum.Czolg.Tests;

import pl.Quantum.Czolg.Tests.Test.Test;
import pl.Quantum.Czolg.Main.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestMeneger {
    private static final String path = Main.getPath()+"Tests"+File.separatorChar;
    private final List<Test> testList = new ArrayList<>();
    private int testNumber = 0; // TODO: 15.07.2022 next test 
    public TestMeneger(){
        File directory = new File(path);

        for (File file : Objects.requireNonNull(directory.listFiles()))
            testList.add(new Test(file));
    }

    public Test getCurrentTest(){
        return testList.get(testNumber);
    }
}
