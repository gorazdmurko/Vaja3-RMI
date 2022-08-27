# Vaja3-RMI

# MODULE DEPENDENCIES
1. Vaja3-Service --> Vaja3-ServiceItf
2. Vaja3-RmiServer --> Vaja3-ServiceItf, Vaja3-Service
3. Vaja3-RmiClient --> Vaja3-ServiceItf



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
