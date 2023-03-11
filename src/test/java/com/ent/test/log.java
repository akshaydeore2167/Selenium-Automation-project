package com.ent.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class log {

Logger LOGGER=Logger.getLogger( this.getClass().getName() );
    @Test
    public void log(){
        LOGGER.info( "Hello Akki" );
    }

}
