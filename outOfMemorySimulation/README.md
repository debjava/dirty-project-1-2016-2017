# Notes



-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp

-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/dirty-idea-aug-2016/outOfMemorySimulation/dump



mvn exec:exec -Dexec.executable=java -Dexec.args="-classpath target/classes -XX:+PrintGCDetails com.test.Test"

mvn exec:exec -Dexec.executable=java -Dexec.args="-classpath target/classes -XX:+PrintGCDetails com.ddlab.rnd.core.TestOutOfMemory

**Correct command below**

mvn exec:exec -Dexec.executable=java -Dexec.args="-classpath target/classes -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/dirty-idea-aug-2016/outOfMemorySimulation/dump com.ddlab.rnd.core.TestOutOfMemory




AS of Now, final command
mvn exec:exec -Dexec.executable=java -Dexec.args="-classpath target/classes -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/dirty-idea-aug-2016/outOfMemorySimulation/dump com.ddlab.rnd.core.TestOutOfMemory"