package Entities;

import javax.ejb.Stateless; 
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Stateless
@ApplicationPath("/Calculator")
public class MyApp extends Application {

}
