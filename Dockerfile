FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

USER root
COPY Corporate_Internal_Issuing_CA_2019_Corporate_Internal_Root_CA_2019.cer $JAVA_HOME/lib/security
RUN \
    cd $JAVA_HOME/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias sopra -file Corporate_Internal_Issuing_CA_2019_Corporate_Internal_Root_CA_2019.cer


ENTRYPOINT ["java","-jar","/app.jar"]