# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all files in the current directory to the container's working directory
COPY . /app

# Compile the Java files
RUN javac Main.java

# Specify the default command to run the application
CMD ["java", "Stock Management System"]
