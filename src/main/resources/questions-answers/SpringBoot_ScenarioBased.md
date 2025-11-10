
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

![Spring Boot Performance Monitoring](./profiling_section.png)

1.**Identify Symptoms & Scope**  
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

## 🔹 How would you scale your springboot application to handle increased traffic and what spring boot feature can assist with this?

When scaling a Spring Boot application to handle increased traffic, you should combine **system design scaling strategies** with **Spring Boot performance optimization features**.

---

### **1. Horizontal Scaling**
- **Definition:** Adding more instances of your application to handle traffic by distributing requests.
- **How to Implement:**
    - Deploy multiple stateless instances of the application.
    - Use a load balancer (e.g., **NGINX**, **AWS ALB**, **GCP Load Balancer**).
    - Container orchestration platforms like **Kubernetes** or **Docker Swarm** can manage scaling automatically based on traffic.
- **Usage Scenario:** Best for microservices or stateless apps where load can be spread evenly.

---

### **2. Vertical Scaling**
- **Definition:** Increasing the resources (CPU, memory, disk I/O) of your existing servers/nodes.
- **How to Implement:**
    - Upgrade your cloud instance to a higher tier (AWS EC2, Azure VM, GCP Compute Engine).
- **Usage Scenario:** Quick fix but limited by hardware capabilities.

---

### **3. Asynchronous Processing**
- **Spring Boot Feature:** Use the `@Async` annotation to run long-running methods in separate threads.
- **Example:**
```java
@Async
public void processOrder(Order order) {
    // Time-consuming order processing logic
}
```

---

### **4. Caching**
Caching reduces repetitive database hits and speeds up API responses by storing frequently accessed data in memory.

#### **Key Annotations in Spring Boot:**
- **@Cacheable**  
  - Caches the result of a method so subsequent calls with the same parameters return the cached value instead of executing the method again.
```java
@Cacheable(value = "orders")
public List<Order> getOrders() {
    // This will fetch from DB only if "orders" cache is empty
    return orderRepository.findAll();
}
```

- **@CacheEvict**
    - Removes outdated cache entries after data changes.
    - This is useful when cached data becomes stale after an update or delete.
    - Supported Providers: Redis, Caffeine, EhCache, Hazelcast, etc.
```java
@CacheEvict(cacheNames = {"order", "orders"}, allEntries = true, key = "#id")
public void updateOrder(String id, Order updatedOrder) {
    orderRepository.save(updatedOrder);
}
```

---

### **5. Summary Table**
| Scaling Strategy         | Spring Boot Feature / Tool              | Purpose                                                                 |
|--------------------------|-----------------------------------------|-------------------------------------------------------------------------|
| Horizontal Scaling       | Infrastructure (Kubernetes, Load Balancer) | Distribute traffic across multiple application instances               |
| Vertical Scaling         | Infrastructure Upgrade                  | Increase server capacity (CPU, RAM, network)                           |
| Asynchronous Processing  | `@Async` annotation                     | Process tasks in parallel without blocking request threads             |
| Caching                  | `@Cacheable`, `@CacheEvict`             | Reduce database load & improve response speed by storing frequent data |

**✅ Recommendation:** Combine **Horizontal Scaling** with **Asynchronous Processing** and **Caching** for optimal performance under high traffic.


## 🔹 How do you manage transactions in a Spring Boot Application? and what code is running internally when using the @Transactional annotation

### **Managing Transactions in Spring Boot**
Spring Boot supports declarative transaction management using the **`@Transactional`** annotation from Spring Framework.  
This annotation works at the **service layer** to ensure **ACID properties** (Atomicity, Consistency, Isolation, Durability) in database operations.

---

### **Usage Example**
```java
@Service
public class PaymentService {

    @Transactional
    public void processPayment(Order order, Payment payment) {
        orderRepository.save(order);
        paymentRepository.save(payment);

        // If any runtime exception occurs here, both saves will be rolled back
    }
}
```

### **How It Works Internally**
When Spring encounters the `@Transactional` annotation:

1. **Proxy Creation**  
   - Spring creates a proxy for the annotated class or method (using **JDK dynamic proxy** if implementing an interface, or **CGLIB** if it's a concrete class).  
   - This proxy intercepts method calls to wrap them in transaction boundaries.

2. **Method Interception**  
   - The proxy delegates control to Spring's **TransactionInterceptor**, which decides when to open and close a transaction.

3. **Transaction Management**  
   - The underlying **PlatformTransactionManager** (e.g., `DataSourceTransactionManager` for JDBC, `JpaTransactionManager` for JPA/Hibernate) begins a transaction before method execution.
   - Business logic executes inside this transaction context.

4. **Commit / Rollback Logic**
   - If the method completes successfully, the transaction manager **commits** the transaction.
   - If a `RuntimeException` or `Error` occurs, it **rolls back** the transaction by default (checked exceptions do not trigger rollback unless configured via `rollbackFor`).

---

### **Key Points**
- **Default Rollback Behavior:**  
  - Rolls back on `RuntimeException` and `Error` by default.  
  - Checked exceptions (`Exception`) require explicit `rollbackFor`.

- **Propagation Behavior:**  
  - Controls how transactions propagate when calling other transactional methods (`REQUIRED`, `REQUIRES_NEW`, `MANDATORY`, etc.).

- **Isolation Levels:**  
  - Defines data visibility in concurrent transactions (`READ_COMMITTED`, `REPEATABLE_READ`, `SERIALIZABLE`, etc.).

- **Timeout Settings:**  
  - Ensures a transaction is rolled back if not completed within the defined time limit.

```java
@Transactional(
    rollbackFor = {SQLException.class},
    noRollbackFor = {IllegalArgumentException.class},
    isolation = Isolation.READ_COMMITTED,
    propagation = Propagation.REQUIRED,
    timeout = 30
)
public void customTransactionMethod() {
    // Your logic here
}
```

---

### **Internal Pseudo-Code Flow**
```java
TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

try {
    // Execute target method
    targetMethod();

    transactionManager.commit(status);  // Commit on success
} catch (RuntimeException | Error ex) {
    transactionManager.rollback(status); // Rollback on failure
    throw ex; // Rethrow the exception
}
```

---

### **Propagation Behaviors in `@Transactional` Annotation**

In Spring, **transaction propagation** defines how the existing transaction context is handled when a transactional method is called **inside another transactional context**.  
It is configured via the `propagation` attribute in `@Transactional`.

---

#### **1. REQUIRED (Default)**
- **Behavior:** Use the **existing transaction** if one exists; otherwise, create a **new transaction**.
- **Usage:** Most common — works well in most business operations.
- **Example:**  
```java
@Transactional(propagation = Propagation.REQUIRED)
public void methodA() {
    // Uses existing transaction or starts new if none exists
}
```

#### **2. REQUIRES_NEW**
- **Behavior:** Always **create a new transaction**, suspending the current one if it exists.
- **Usage:** For operations that must always run in their own transaction.
- **Example:**  
```java
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void methodB() {
    // Always starts a new transaction
}
```

#### **3. SUPPORTS**
- **Behavior:** Execute in the current transaction if one exists, otherwise execute non-transactionally.
- **Usage:** For read-heavy operations that can work without a transaction.
- **Example:**  
```java
@Transactional(propagation = Propagation.SUPPORTS)
public void methodC() {
    // Runs in current transaction or outside transaction
}
```

#### **4. NOT_SUPPORTED**
- **Behavior:** Execute non-transactionally, suspending the current transaction if it exists.
- **Usage:** For operations that should never run in a transaction.
- **Example:**  
```java
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public void methodD() {
    // Runs without transaction
}
```

#### **5. MANDATORY**
- **Behavior:** Must run in an existing transaction; throws an exception if none exists.
- **Usage:** For operations that must be part of an existing transaction.
- **Example:**  
```java
@Transactional(propagation = Propagation.MANDATORY)
public void methodE() {
    // Must be in an existing transaction
}
```

#### **6. NEVER**
- **Behavior:** Must not run in a transaction; throws an exception if one exists.
- **Usage:** For operations that cannot run in a transaction.
- **Example:**  
```java
@Transactional(propagation = Propagation.NEVER)
public void methodF() {
    // Cannot be in a transaction
}
```

#### **7. NESTED**
- **Behavior:** Execute in a nested transaction if a transaction already exists; otherwise, behave as REQUIRED.
- **Usage:** For nested transaction support (requires savepoint support).
- **Example:**  
```java
@Transactional(propagation = Propagation.NESTED)
public void methodG() {
    // Nested transaction if existing, else new
}
```

---

### **Summary Table – Propagation Types in `@Transactional`**

| Propagation Type  | Joins Existing Transaction? | Creates New Transaction If None Exists? | Suspends Existing Transaction? | Throws Exception If No Transaction Exists? | Typical Use Case |
|-------------------|-----------------------------|------------------------------------------|---------------------------------|---------------------------------------------|------------------|
| **REQUIRED** (Default) | ✅ Yes | ✅ Yes | ❌ No | ❌ No | Most business logic where a transaction is needed if none exists. |
| **REQUIRES_NEW** | ❌ No | ✅ Yes | ✅ Yes | ❌ No | Operations that must always run in their own transaction (e.g., independent logging). |
| **SUPPORTS** | ✅ Yes | ❌ No | ❌ No | ❌ No | Read-only or optional transaction operations. |
| **NOT_SUPPORTED** | ❌ No | ❌ No | ✅ Yes | ❌ No | Long-running tasks or processes that should never run in a transaction. |
| **MANDATORY** | ✅ Yes | ❌ No | ❌ No | ✅ Yes | Enforce that a method must be called inside an existing transaction. |
| **NEVER** | ❌ No | ❌ No | ❌ No | ✅ Yes | Ensure an operation never runs within a transaction. |
| **NESTED** | ✅ Yes (with savepoint) | ✅ Yes | ❌ No | ❌ No | Partial rollbacks with savepoints inside a larger transaction; requires JDBC savepoint support. |



## 🔹 How can you deploy a small Spring Boot application cost-effectively, ensuring that you only pay for server resources when the application is in use?

### **Understanding the Concept**
For applications that don't require constant uptime or have variable/infrequent traffic, **serverless platforms** (like AWS Lambda, Google Cloud Functions, or Azure Functions) offer a cost-effective and scalable deployment option.

Unlike traditional deployments, you don't provision or manage servers — the cloud provider automatically runs your code when invoked.

---

### **Benefits of Serverless Deployment for Spring Boot**
1. **Pay-per-Use**
    - You only pay for the compute time your application consumes.
    - Ideal for low-traffic or event-driven applications.

2. **Scalability**
    - Serverless platforms automatically scale your application based on demand.
    - No manual intervention required to add/remove capacity.

3. **Reduced Maintenance**
    - No need to manage OS patches, scaling infrastructure, or idle servers.

---

### **Adapting Spring Boot for Serverless**
Spring Boot can run in serverless environments via the **Spring Cloud Function** project, which enables seamless integration with AWS Lambda and other function-as-a-service (FaaS) providers.

---

### **Example – AWS Lambda Deployment**
Using Spring Cloud Function, you can adapt your Spring Boot application with a handler class like below:

```java
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class LambdaHandler extends SpringBootRequestHandler<String, String> {
}
```

---

### **Use Cases in Real Projects**
- **Event-driven microservices**  
  Triggered by events like S3 file uploads, SNS messages, or DynamoDB streams.
- **On-demand APIs**  
  REST endpoints exposed via API Gateway that only execute when users make a request.
- **Scheduled tasks**  
  Periodic jobs triggered by AWS CloudWatch Events instead of a continuously running scheduler.
- **Data processing pipelines**  
  Real-time processing of incoming data streams or batch jobs without keeping a persistent server.

---

### **Pros**
✅ **Cost-efficient** – Perfect for applications with sporadic workloads as you pay only for execution time.  
✅ **Auto-scaling** – Instantly scales up or down based on demand.  
✅ **Low maintenance** – No server patching, OS updates, or idle resource costs.  
✅ **Quick deployment** – Deploy functions independently for rapid iteration.

---

### **Cons**
⚠️ **Cold start latency** – Larger Spring Boot apps may have slower startup when scaling from zero.  
⚠️ **Execution limits** – AWS Lambda max execution time is 15 minutes.  
⚠️ **Resource limits** – Memory and ephemeral storage constraints may require application adjustments.  
⚠️ **State management** – Must be stateless; managing sessions requires external storage (e.g., Redis).

---

### **Recommendation**
For **small to medium-sized Spring Boot services** with **burst traffic patterns** or **infrequent usage**,  
use **Spring Cloud Function** with **AWS Lambda** for:
- Optimal cost-efficiency (pay-per-use billing model).
- Automatic scalability without DevOps overhead.
- Easy event-driven integrations with AWS services.

💡 **Tip:** Minimize cold starts by reducing unused dependencies and keeping the codebase modular.  
Also, consider using **Provisioned Concurrency** in AWS Lambda if consistent low-latency responses are critical.
