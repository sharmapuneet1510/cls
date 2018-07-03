package com.nomura.application.runner;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Run
	{
		private static Logger logger = Logger.getLogger(Run.class);
		
		static
			{
				try
					{
						Resource resource = new ClassPathResource("properties" + File.separator + "log4j.properties");
						Properties properties = new Properties();
						properties.load(resource.getInputStream());
						PropertyConfigurator.configure(properties);
						logger.info("Congifuring logger");
					}
				catch (Exception exception)
					{
						logger.error("Exception while loading Log4j.properties", exception);
					}
			}
			
		public static void main(String[] args)
			{
				SpringApplication springApplication = new SpringApplication(Run.class);
				springApplication.setHeadless(false);
				springApplication.setBannerMode(Banner.Mode.OFF);
				springApplication.setWebEnvironment(false);
				springApplication.run(args);
				int i = 0;
				while (i < 10)
					{
						logger.info("User " + UUID.randomUUID().toString());
						i = i + 1;
					}
					
			}
	}
