package log4j_use;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo_log4j {

	static Logger log =LogManager.getLogger(Demo_log4j.class);
	
	public static void main(String[] args) {
		  
		System.out.println("welcome to logger");
		
		log.trace("this is trace msg");
		log.info("this is information msg");
		log.error("this is an error msg");
		log.fatal("this is fatal msg");
		log.warn("this is an warn msg");

		System.out.println(" \n completed");
	}

}
