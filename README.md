spring-boot-oracle-jpa-app

To install the Oracle jdbc drivers :

1. ojdbc6.jar

$ mvn install:install-file -Dfile={Path/to/your/ojdbc6.jar} -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

or 2. ojdbc7.jar

$ mvn install:install-file -Dfile={Path/to/your/ojdbc7.jar} -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar
