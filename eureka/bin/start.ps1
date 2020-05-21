Write-Output "Fetch dependency...."
mvn dependency:resolve -f ./pom.xml
Write-Output "Packaging JAR..."
mvn package -f ./pom.xml
Write-Output "Starting server..."
java -jar ./target/eureka-0.0.1-SNAPSHOT.jar
