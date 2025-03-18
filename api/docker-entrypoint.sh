#!/bin/sh

export TERM=xterm

# Start Spring Boot without Debugging
./mvnw spring-boot:run -Dspring-boot.run.fork=false &

# Watch for Java file changes, compile, and trigger restart
while true; do
    watch -d -t -g "ls -lR src/main/java | sha1sum" && ./mvnw compile && touch src/main/java/.restart
done