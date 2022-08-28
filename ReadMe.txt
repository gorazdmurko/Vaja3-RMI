~~~~~~~~~~~~~~~~~~~~
~~~~~ COMPILER ~~~~~
~~~~~~~~~~~~~~~~~~~~
IN EVERY POM.XML ADD MAVEN COMPILER DEPENDENCY
<!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin -->
<dependency>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.10.1</version>
</dependency>



~~~~~~~~~~~~~~~
~~~~~ RMI ~~~~~
~~~~~~~~~~~~~~~
1. RUN -> run ServerMain ( javi napako "can't connect" )

2. COPY
	-> copy path ( C:\...\Vaja3-ServiceItf\target\classes )
	-> set classpath=  path  ( v teminal )

3. OPEN FOLDER 	
	-> Java\jdk-16\bin
	-> rmiregistry.exe

4. RUN -> ServerMain ( mora se izpisati 'Server Ready' )

5. AppMain -> run AppMain


set CLASSPATH=C:\\Users\\Gorazd Murko\\Desktop\\PROGRAMIRANJE\\JAVA\\VAJE_oblonsek\\Vaja3-RMI\\unit29_Vaje\\Vaja3-ServiceItf\\target\\classes
cd C:\Program Files\Java\jdk-16.0.1\bin