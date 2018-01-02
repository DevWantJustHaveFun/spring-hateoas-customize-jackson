# spring-hateoas-customize-jackson

Sample repository for testing jackson customization with Spring-Hateos and Java 8 date (JSR-310 module)
 
Based on gregturn's sample repository and this issue https://github.com/spring-projects/spring-hateoas/issues/333 

the main lesson of my investigation is when you use this jackson feature :
spring.jackson.serialization.write-dates-as-timestamps=false
spring.jackson.serialization.write-date-timestamps-as-nanoseconds=false

you should add this dependency :
com.fasterxml.jackson.datatype => jackson-datatype-jsr310



