# System Design and Scalability

## System Design in the Interview

System Design discussions should represent a very candid conversation, truly mimicking if your boss came up to you
and wanted to discuss implementing a new system. Communication is an important aspect to keep in mind, which
can greatly reduce the complexity to design problems. The following is a list of helpful things to keep in mind:

1. Communicate with your interviewer, ask questions for clarity, acknowledge pros and cons to the system you're
designing.

2. Stay at an overview picture before getting into any specifics.

3. Use the whiteboard to help explain the system.

4. Ask your interviewer about the concerns, and address them.

5. State assumptions you're making, and get feedback from the interviewer to ensure these assumptions are valid.

6. It's okay to estimate.

7. Be the driver of the system design conversation.

## Steps to System Design

1. **Getting an overview and understanding of a problem**
As you would normally need clarifying questions to understand a system your boss wants you to build, ask these to
the interviewer. Make sure you understand all of the main features to the system. E.g. do you need user accounts? 
Will you need a database? Will users be able to express a number of different inputs? Do you need any trace logs or 
analytics for the system?

2. **Highlight some assumptions you're considering for designing this system**
E.g. If you're strictly interviewing for front-end position, you could make the assumption that your get request simply
communicates with the back-end and the back-end is already designed to handle the different API routes respectively.

Other assumptions could be that of use case scenarios, e.g. you could make the assumption that ages
cap at 150 years old for users.

You should not make assumptions about data sizes and scale; get clarity here. E.g. you should not make an
assumption that your system will only have a few hundred users.

3. **Visualize the system**
Utilize the whiteboard to start drawing out the system. Walk through a potential flow of the system.

4. **Identify the issues in your system**
What is challenging about your design? Are there any cases that break its implementation? Consider issues of
database hits, data sizes, or threading.

5. **Adjust your design for the major issues**

## Concepts to know

### `Vertical Scaling`
Add more resources (CPU, RAM, DISK) to your server or node. This is often a solution for moderately sized
applications or small - to mid-sized companies. Vertical scaling can be thought of as upgrading a server's hardware.
Vertical scaling allows for the increase of I/O, or CPU/RAM/DISK capacities. This scaling is often associated with
down times. This is generally an easier method, but is more limited.

### `Horizontal Scaling`
Horizontal scaling refers to increasing the number of servers or nodes. This can be beneficial as it decreases the load
on any one server. This is usually a method used when server services are in high demand. Increasing the number of
nodes allows for more server end-points for client connections. This process decreases the load, being that it is now
distributed over different nodes. Other benefits include increasing I/O concurrency and improving DISK capacity. This
is a technique almost guaranteed to be used by giant companies like Google or Amazon.

### `Load Balancer`
Load balancing entails the distributing incoming network traffic across a network of back-end servers. A load
balancer distributes the load evenly to prevent a server crash. This requires a network of duplicated servers that are
essentially built on the same code, and access the same data. This is a solution used when there is a significant
number of concurrent requests from clients. A load balancer is responsible for directing the traffic to maximize the
system's speed and capacity constraints.
- Distribute client requests across many servers
- Allows for available data, speed, and reliability for requests and only access online servers
- We can add or remove servers to match the demand.

**Load Balancer Algorithms**

1. Round Robin

2. Least Connections

3. Least Time

4. Hash

5. IP Hash

### `Denormalizing the database`

To improve read speeds, we can add redundant information to records as to minimize the number of joins we need
to make to work with the database. For example, I may wish to know the salesperson a sale is associated with, and
we may store the sale's person unique id as a foreign key for our sales record. However, we may wish to also store 
the name of the salesperson on the sales record so that we can quickly access it instead of having to join on the sales
person id and then access their name.

NoSQL databases are particularly designed for scaling well.


### `Database Partitioning a.k.a. Sharding`

**Sharding** - Splitting the data across many machines while maintaining a system to figure out what data lives on
each machine.

**Vertical Partitioning** - this strategy entails splitting your data (tables or collections) by specific features. For
example, each table of a database may live on a separate machine. This strategy can become difficult when individual
tables or partitions overflow the current machine and need to be partitioned again.

**Key-Based (Hash-Based) Partitioning** - providing a key for the data, the space is partitioned around mod(key, n),
with N servers. This method uses a fixed number of servers. If more servers are to be added, then all of the data
needs to be reallocated, which can be costly.

**Directory-Based Partitioning** - This strategy entails a lookup table to find where the data is stored. This process
allows for the ease of adding more servers, however, it can introduce a single point of failure with the lookup table
and continuously accessing the table can negatively impact performance.

### `Caching`




































