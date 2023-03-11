package com.ent.docker_grid;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Docker_Grid_Setup {

    @BeforeTest
    public void start_docker_grid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec( "cmd /c start Start_Docker.bat" );
        Thread.sleep( 25000 );
    }
    @AfterTest
    public void stop_docker_grid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec( "cmd /c start Stop_Docker.bat" );
        Thread.sleep( 10000 );
        Runtime.getRuntime().exec( "taskkill /f /im cmd.exe" );


    }
}
