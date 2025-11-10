## 🔹 How can you validate two specific conditions in a YAML property file while creating a bean in a SpringBoot Application?

- **@ConditionalOnExpression**
    
    When bean needs to be created based on some non-boolean value
    ```java
    @Bean
    @ConditionalOnExpression(
        "'${app.mode}'=='DEV' and '${app.feature}'=='ENABLED'"
    )
    public MyService myService() {
        return new MyService();
    }
    ```

- **@ConditionalOnProperty**

    When bean needs to be created based on some boolean value from YAML file.
    ```java
    @Bean
    @ConditionalOnProperty(
        name = {"feature.enabled", "feature.beta"},
        havingValue = "true",
        matchIfMissing = false
    )
    public BetaFeatureService betaFeatureService() {
        return new BetaFeatureService();
    }
    ```

## 🔹 Your SpringBoot application is facing Performance issue under high load. What steps would you take to diagnose and resolve the problem?

1. **Identify Symptoms & Scope**  
   - Check logs for error spikes, slow API responses, or thread pool exhaustion.
   - Observe CPU, memory, and heap usage patterns.

2. **Enable Detailed Monitoring**
   - Use **Spring Boot Actuator** endpoints (`/metrics`, `/health`, `/threaddump`) for real-time insight.
   - Integrate APM tools (e.g., **New Relic**, **AppDynamics**, **Datadog**, **Prometheus + Grafana**) to track service performance.
   
3. **Profile the Application**
   - Use profilers (**VisualVM**, **JProfiler**, **YourKit**) to detect bottlenecks in code execution.
   - Analyze garbage collection behavior (`-Xloggc` / GC logs).

4. **Database Performance Checks**
   - Enable SQL logging (`spring.jpa.show-sql=true`) in non-prod.
   - Identify long-running queries via DB monitoring tools or adding indexes where needed.
   - Implement connection pooling (e.g., **HikariCP**) with tuned settings.

5. **Thread Pool and Async Tasks**
   - Review `@Async`, web, and executor thread pool configurations.
   - Ensure long-running tasks do not block request-handling threads.

6. **Caching Strategies**
   - Use caching for frequently accessed data (**Spring Cache**, Redis, or Caffeine).
   - Optimize expensive computations with `@Cacheable`.

7. **Configuration & Network**
   - Tune JVM heap size for sufficient allocation.
   - Review API gateway and load balancer configurations.
   - Consider compression and pagination to reduce payload size.

8. **Load Testing & Benchmarking**
   - Simulate high load using tools like **JMeter**, **Gatling**, or **k6**.
   - Benchmark critical APIs and track changes with profiling.

9. **Optimize Code**  
   - Refactor inefficient loops, bulky objects, or repeated queries.
   - Use asynchronous/event-driven approaches for non-blocking tasks.

10. **Scaling**
    - Implement horizontal scaling (add more application instances).
    - Use Kubernetes or cloud auto-scaling features.
    - Enable HTTP connection pooling and proper timeouts.

💡 **Tip:** Always reproduce the issue in a staging environment before applying fixes in production!