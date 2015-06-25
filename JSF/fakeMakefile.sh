#!/bin/bash
echo "compilo..."
risComp=$(javac -d WEB-INF/classes/ -classpath WEB-INF/lib/javax.faces-2.2.8.jar:WEB-INF/lib/postgresql-9.3-1100.jdbc4.jar src/it/ablp/RecuperoDati.java src/it/ablp/Strumento.java src/it/ProdView.java)

if [ -z $risComp ]
	then
		echo "compilazione completata"
		esiste=$(pidof java)
		if [ -z $esiste ]
			then
				echo "faccio partire tomcat"
				tomcat start
			else
				echo "faccio ripartire tomcat"
				tomcat restart
		fi
		firefox localhost:8080/progetto/
	else
		echo "compilazione fallita"
		echo $risComp
fi

