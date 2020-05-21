[CmdletBinding()]
param ([String]$mode)
Write-Output "Fetch dependency...."
mvn dependency:resolve -f ./pom.xml
Write-Output "Packaging JAR..."
mvn package -f ./pom.xml
Write-Output "Starting server..."
if([String]::IsNullOrEmpty($mode)){
    java -jar ./target/eureka-client-0.0.1-SNAPSHOT.jar
}else {
    cp ./target/eureka-client-0.0.1-SNAPSHOT.jar ./target/eureka-client-0.0.1-SNAPSHOT-$mode.jar
    java -jar ./target/eureka-client-0.0.1-SNAPSHOT-$mode.jar --spring.profiles.active=$mode
}