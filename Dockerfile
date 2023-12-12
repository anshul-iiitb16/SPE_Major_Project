FROM openjdk:11
COPY ./target/Emp_Management_System-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
# The EXPOSE instruction informs Docker that the container listens on the specified network ports at runtime.
EXPOSE 8082
CMD ["java","-jar","Emp_Management_System-0.0.1-SNAPSHOT.jar"]
