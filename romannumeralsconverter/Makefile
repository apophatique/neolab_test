all: clean-and-package clearscreen run

clean:
	mvn clean

clean-and-package:
	mvn clean package

package:
	mvn package

run:
	java -jar ./target/romannumeralsconverter-1.0-SNAPSHOT.jar

clearscreen:
	clear